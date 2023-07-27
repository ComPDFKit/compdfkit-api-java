//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit;


import com.compdfkit.client.CPDFClient;
import com.compdfkit.constant.CPDFConstant;
import com.compdfkit.enums.CPDFConversionEnum;
import com.compdfkit.param.CPDFToJpgParameter;
import com.compdfkit.pojo.comPdfKit.CPDFCreateTaskResult;
import com.compdfkit.pojo.comPdfKit.CPDFFileInfo;
import com.compdfkit.pojo.comPdfKit.CPDFTaskInfoResult;
import com.compdfkit.pojo.comPdfKit.CPDFUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PDFToJpg {

    private static final String publicKit = "";
    private static final String secretKey = "";
    private static final CPDFClient client = new CPDFClient(publicKit,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        PDFToJpg.pdfToJpg();
    }

    public static void pdfToJpg() throws FileNotFoundException {
        // create Task
        CPDFCreateTaskResult CPDFCreateTaskResult = client.createTask(CPDFConversionEnum.PDF_TO_JPG);
        // taskId
        String taskId = CPDFCreateTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        String filePassword = "";
        CPDFToJpgParameter fileParameter = new CPDFToJpgParameter();
        CPDFUploadFileResult CPDFUploadFileResult = client.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CPDFUploadFileResult.getFileKey();
        // perform tasks
        client.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CPDFTaskInfoResult taskInfo = client.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(CPDFConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CPDFFileInfo fileInfo = client.getFileInfo(fileKey);
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
