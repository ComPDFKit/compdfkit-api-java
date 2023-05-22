//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

public class FileInfo {

    /**
     * file unique identifier
     */
    private String fileKey;

    /**
     * taskId
     */
    private String taskId;

    /**
     * fileName
     */
    private String fileName;

    /**
     * fileUrl
     */
    private String fileUrl;

    /**
     * downloadUrl
     */
    private String downloadUrl;

    /**
     * sourceType
     */
    private String sourceType;

    /**
     * targetType
     */
    private String targetType;

    /**
     * fileSize
     */
    private String fileSize;

    /**
     * convertSize
     */
    private String convertSize;

    /**
     * convertTime
     */
    private String convertTime;

    /**
     * status
     */
    private String status;

    /**
     * failureCode
     */
    private String failureCode;

    /**
     * failureReason
     */
    private String failureReason;

    /**
     * downFileName
     */
    private String downFileName;

    /**
     * fileParameter
     */
    private String fileParameter;

    public String getFileParameter() {
        return fileParameter;
    }

    public void setFileParameter(String fileParameter) {
        this.fileParameter = fileParameter;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getConvertSize() {
        return convertSize;
    }

    public void setConvertSize(String convertSize) {
        this.convertSize = convertSize;
    }

    public String getConvertTime() {
        return convertTime;
    }

    public void setConvertTime(String convertTime) {
        this.convertTime = convertTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getDownFileName() {
        return downFileName;
    }

    public void setDownFileName(String downFileName) {
        this.downFileName = downFileName;
    }
}
