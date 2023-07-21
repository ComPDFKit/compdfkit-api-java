//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit;


import cn.kdan.compdfkit.client.ComPDFKitClient;
import cn.kdan.compdfkit.constant.ComPDFKitConstant;
import cn.kdan.compdfkit.enums.CPDFToOfficeEnum;
import cn.kdan.compdfkit.param.CPDFToRtfParameter;
import cn.kdan.compdfkit.pojo.comPdfKit.CCreateTaskResult;
import cn.kdan.compdfkit.pojo.comPdfKit.CFileInfo;
import cn.kdan.compdfkit.pojo.comPdfKit.CTaskInfoResult;
import cn.kdan.compdfkit.pojo.comPdfKit.CUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CPDFToCsv {

    private static final String publicKit = "";
    private static final String secretKey = "";
    private static final ComPDFKitClient comPDFKitClient = new ComPDFKitClient(publicKit,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        CPDFToCsv.pdfToCsv();
    }

    public static void pdfToCsv() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_RTF);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        String filePassword = "";
        CPDFToRtfParameter fileParameter = new CPDFToRtfParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

}
