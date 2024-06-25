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
import com.compdfkit.enums.CPDFDocumentEditorEnum;
import com.compdfkit.param.CPDFAddWatermarkParameter;
import com.compdfkit.param.CPDFContentComparisonParameter;
import com.compdfkit.param.CPDFOverlayComparisonParameter;
import com.compdfkit.pojo.comPdfKit.CPDFCreateTaskResult;
import com.compdfkit.pojo.comPdfKit.CPDFFileInfo;
import com.compdfkit.pojo.comPdfKit.CPDFTaskInfoResult;
import com.compdfkit.pojo.comPdfKit.CPDFUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareDocuments {

    private static final String publicKey = "";
    private static final String secretKey = "";
    private static final CPDFClient client = new CPDFClient(publicKey,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        CompareDocuments.contentComparison();
//        CompareDocuments.overlayComparison();
    }

    public static void contentComparison() throws FileNotFoundException {
        // create Task
        CPDFCreateTaskResult createTaskResult = client.createTask(CPDFDocumentEditorEnum.PDF_CONTENT_COMPARE, CPDFLanguageConstant.ENGLISH);
        // taskId
        String taskId = createTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        File file1 = new File("sample/test1.pdf");
        String filePassword = "";
        CPDFContentComparisonParameter fileParameter = new CPDFContentComparisonParameter();
        fileParameter.setIsSaveTwo(false);
        fileParameter.setImgCompare(true);
        fileParameter.setTextCompare(true);
        fileParameter.setReplaceColor("#93B9FD");
        fileParameter.setInsertColor("#C0FFEC");
        fileParameter.setDeleteColor("#FBBDBF");
        CPDFUploadFileResult uploadFileResult = client.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName(), CPDFLanguageConstant.ENGLISH);
        String fileKey = uploadFileResult.getFileKey();

        CPDFUploadFileResult uploadFileResult1 = client.uploadFile(new FileInputStream(file1),taskId,filePassword,fileParameter,file.getName(), CPDFLanguageConstant.ENGLISH);

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

    public static void overlayComparison() throws IOException {
        // create Task
        CPDFCreateTaskResult createTaskResult = client.createTask(CPDFDocumentEditorEnum.PDF_COVER_COMPARE, CPDFLanguageConstant.ENGLISH);
        // taskId
        String taskId = createTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        File file1 = new File("sample/test1.pdf");
        String filePassword = "";
        CPDFOverlayComparisonParameter fileParameter = new CPDFOverlayComparisonParameter();
        fileParameter.setInTransparency("0.5");
        fileParameter.setNewTransparency("0.5");
        fileParameter.setCoverType("0");
        fileParameter.setInColor("#FBBDBF");
        fileParameter.setNewColor("#93B9FD");
        CPDFUploadFileResult uploadFileResult = client.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName(), CPDFLanguageConstant.ENGLISH);
        String fileKey = uploadFileResult.getFileKey();

        CPDFUploadFileResult uploadFileResult1 = client.uploadFile(new FileInputStream(file1),taskId,filePassword,fileParameter,file.getName(), CPDFLanguageConstant.ENGLISH);

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
