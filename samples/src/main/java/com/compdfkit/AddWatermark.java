//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
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
import com.compdfkit.pojo.comPdfKit.CPDFCreateTaskResult;
import com.compdfkit.pojo.comPdfKit.CPDFFileInfo;
import com.compdfkit.pojo.comPdfKit.CPDFTaskInfoResult;
import com.compdfkit.pojo.comPdfKit.CPDFUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddWatermark {

    private static final String publicKey = "";
    private static final String secretKey = "";
    private static final CPDFClient client = new CPDFClient(publicKey,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        AddWatermark.addWatermarkText();
//        AddWatermark.addWatermarkImage();
    }

    public static void addWatermarkText() throws FileNotFoundException {
        // create Task
        CPDFCreateTaskResult createTaskResult = client.createTask(CPDFDocumentEditorEnum.ADD_WATERMARK, CPDFLanguageConstant.ENGLISH);
        // taskId
        String taskId = createTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        String filePassword = "";
        CPDFAddWatermarkParameter fileParameter = new CPDFAddWatermarkParameter();
        fileParameter.setType("text");
        fileParameter.setScale("1");
        fileParameter.setOpacity("0.5");
        fileParameter.setRotation("0.785");
        fileParameter.setTargetPages("1-2");
        fileParameter.setVertalign("center");
        fileParameter.setHorizalign("left");
        fileParameter.setXoffset("100");
        fileParameter.setYoffset("100");
        fileParameter.setContent("test");
        fileParameter.setTextColor("#59c5bb");
        fileParameter.setFullScreen("1");
        fileParameter.setHorizontalSpace("10");
        fileParameter.setVerticalSpace("10");
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

    public static void addWatermarkImage() throws IOException {
        // create Task
        CPDFCreateTaskResult createTaskResult = client.createTask(CPDFDocumentEditorEnum.ADD_WATERMARK, CPDFLanguageConstant.ENGLISH);
        // taskId
        String taskId = createTaskResult.getTaskId();
        // upload File
        File file = new File("sample/test.pdf");
        String filePassword = "";
        CPDFAddWatermarkParameter fileParameter = new CPDFAddWatermarkParameter();
        fileParameter.setType("image");
        fileParameter.setScale("0.5");
        fileParameter.setOpacity("0.5");
        fileParameter.setRotation("45");
        fileParameter.setTargetPages("1-2");
        fileParameter.setVertalign("center");
        fileParameter.setHorizalign("left");
        fileParameter.setXoffset("50");
        fileParameter.setYoffset("50");
        fileParameter.setFullScreen("1");
        fileParameter.setHorizontalSpace("100");
        fileParameter.setVerticalSpace("100");
        fileParameter.setFront("1");
        CPDFUploadFileResult uploadFileResult = client.uploadFile(file,taskId,fileParameter,new File("sample/test.jpg"));
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
