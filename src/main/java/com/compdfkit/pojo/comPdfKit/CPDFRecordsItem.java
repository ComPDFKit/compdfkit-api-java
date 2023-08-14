//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.pojo.comPdfKit;

public class CPDFRecordsItem {
    private String server;
    private Object updatedBy;
    private String creationTime;
    private int assetTypeId;
    private int taskFailNum;
    private String updateTime;
    private String targetType;
    private int useToolId;
    private int taskCost;
    private Object createdBy;
    private String taskUrl;
    private String sourceType;
    private int taskFileNum;
    private int taskSuccessNum;
    private int tenantId;
    private String taskFinishTime;
    private String callbackUrl;
    private long id;
    private String taskLoadUrl;
    private int projectId;
    private String taskId;
    private String taskStatus;
    private int taskTime;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(int assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public int getTaskFailNum() {
        return taskFailNum;
    }

    public void setTaskFailNum(int taskFailNum) {
        this.taskFailNum = taskFailNum;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public int getUseToolId() {
        return useToolId;
    }

    public void setUseToolId(int useToolId) {
        this.useToolId = useToolId;
    }

    public int getTaskCost() {
        return taskCost;
    }

    public void setTaskCost(int taskCost) {
        this.taskCost = taskCost;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public int getTaskFileNum() {
        return taskFileNum;
    }

    public void setTaskFileNum(int taskFileNum) {
        this.taskFileNum = taskFileNum;
    }

    public int getTaskSuccessNum() {
        return taskSuccessNum;
    }

    public void setTaskSuccessNum(int taskSuccessNum) {
        this.taskSuccessNum = taskSuccessNum;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTaskFinishTime() {
        return taskFinishTime;
    }

    public void setTaskFinishTime(String taskFinishTime) {
        this.taskFinishTime = taskFinishTime;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskLoadUrl() {
        return taskLoadUrl;
    }

    public void setTaskLoadUrl(String taskLoadUrl) {
        this.taskLoadUrl = taskLoadUrl;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }

    @Override
    public String toString() {
        return "RecordsItem{" +
                "server='" + server + '\'' +
                ", updatedBy=" + updatedBy +
                ", creationTime='" + creationTime + '\'' +
                ", assetTypeId=" + assetTypeId +
                ", taskFailNum=" + taskFailNum +
                ", updateTime='" + updateTime + '\'' +
                ", targetType='" + targetType + '\'' +
                ", useToolId=" + useToolId +
                ", taskCost=" + taskCost +
                ", createdBy=" + createdBy +
                ", taskUrl='" + taskUrl + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", taskFileNum=" + taskFileNum +
                ", taskSuccessNum=" + taskSuccessNum +
                ", tenantId=" + tenantId +
                ", taskFinishTime='" + taskFinishTime + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", id=" + id +
                ", taskLoadUrl='" + taskLoadUrl + '\'' +
                ", projectId=" + projectId +
                ", taskId='" + taskId + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskTime=" + taskTime +
                '}';
    }
}
