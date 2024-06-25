//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit;


import com.compdfkit.client.CPDFClient;
import com.compdfkit.constant.CPDFConstant;
import com.compdfkit.constant.CPDFLanguageConstant;
import com.compdfkit.enums.CPDFConversionEnum;
import com.compdfkit.param.CPDFToEditableParameter;
import com.compdfkit.param.CPDFToWordParameter;
import com.compdfkit.pojo.comPdfKit.CPDFCreateTaskResult;
import com.compdfkit.pojo.comPdfKit.CPDFFileInfo;
import com.compdfkit.pojo.comPdfKit.CPDFTaskInfoResult;
import com.compdfkit.pojo.comPdfKit.CPDFUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PDFToEditable {

    private static final String publicKey = "";
    private static final String secretKey = "";
    private static final CPDFClient client = new CPDFClient(publicKey,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        PDFToEditable.pdfToEditable();
    }

    public static void pdfToEditable() throws FileNotFoundException {
        // create Task
        CPDFCreateTaskResult createTaskResult = client.createTask(CPDFConversionEnum.PDF_TO_EDITABLE, CPDFLanguageConstant.ENGLISH);
        // taskId
        String taskId = createTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        String filePassword = "";
        CPDFToEditableParameter fileParameter = new CPDFToEditableParameter();
        fileParameter.setIsAllowOcr(CPDFToEditableParameter.IS_ALLOW_OCR);
        CPDFUploadFileResult uploadFileResult = client.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName(), CPDFLanguageConstant.ENGLISH);
        String fileKey = uploadFileResult.getFileKey();
        // perform tasks
        client.executeTask(taskId, CPDFLanguageConstant.ENGLISH);
        // get task processing information
        CPDFTaskInfoResult taskInfo = client.getTaskInfo(taskId);
        // determine whether the task status is "TaskFinish"
        if (taskInfo.getTaskStatus().equals(CPDFConstant.TASK_FINISH)) {
            System.out.println(taskInfo);
            // get the final file processing information
            CPDFFileInfo fileInfo = client.getFileInfo(fileKey);
            System.out.println(fileInfo);
            // if the task is finished, cancel the scheduled task
        }else {
            System.out.println("Task incomplete processing");
        }
    }


}
