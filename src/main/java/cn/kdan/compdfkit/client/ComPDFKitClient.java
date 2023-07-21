//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.client;


import cn.kdan.compdfkit.enums.CDocumentAIEnum;
import cn.kdan.compdfkit.enums.COfficeToPDFEnum;
import cn.kdan.compdfkit.enums.CPDFServerEnum;
import cn.kdan.compdfkit.enums.CPDFToOfficeEnum;
import cn.kdan.compdfkit.param.CFileParameter;
import cn.kdan.compdfkit.pojo.comPdfKit.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static java.time.Duration.ofSeconds;


public class ComPDFKitClient {

    private final CHttpClient httpClient;

    public ComPDFKitClient(String publicKey, String secretKey) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setConnectTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setBufferRequestBody(false);
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        httpClient = new CHttpClient(restTemplate,publicKey,secretKey);
        httpClient.refreshAccessToken();
    }

    /**
     * get token
     *
     * @param publicKey publicKey
     * @param secretKey secretKey
     * @return String
     */
    private ComPdfKitOauthResult getComPdfKitAuth(String publicKey, String secretKey) {
        return httpClient.getComPdfKitAuth(publicKey, secretKey);
    }

    /**
     * get Support tools
     *
     * @return ToolSupportResult
     */
    public List<CTool> getTools() {
        return httpClient.getTools();
    }

    /**
     * get file info
     *
     * @param fileKey fileKey
     * @return FileInfo
     */
    public CFileInfo getFileInfo(String fileKey) {
        return httpClient.queryFileInfo(fileKey);
    }

    /**
     * queryAssetInfo
     *
     * @return QueryTenantAssetResult
     */
    public CTenantAssetResult getAssetInfo() {
        return httpClient.queryAssetInfo();
    }

    /**
     * queryTaskList
     *
     * @param page page
     * @param size size
     * @return QueryTaskRecordsResult
     */
    public CTaskRecordsResult getTaskList(String page, String size) {
        return httpClient.queryTaskList(page, size);
    }


    /**
     * createTask
     *
     * @param executeTypeUrl task execution type
     * @return CreateTaskResult
     */
    public CCreateTaskResult createTask(String executeTypeUrl) {
        return httpClient.createTask(executeTypeUrl);
    }

    /**
     * createTask
     *
     * @param officeToPDFEnum task execution type
     * @return CreateTaskResult
     */
    public CCreateTaskResult createTask(COfficeToPDFEnum officeToPDFEnum){
        return this.createTask(officeToPDFEnum.getValue());
    }

    /**
     * createTask
     *
     * @param pdfServerEnum task execution type
     * @return CreateTaskResult
     */
    public CCreateTaskResult createTask(CPDFServerEnum pdfServerEnum){
        return this.createTask(pdfServerEnum.getValue());
    }

    /**
     * createTask
     *
     * @param pdfToOfficeEnum task execution type
     * @return CreateTaskResult
     */
    public CCreateTaskResult createTask(CPDFToOfficeEnum pdfToOfficeEnum){
        return this.createTask(pdfToOfficeEnum.getValue());
    }

    /**
     * createTask
     *
     * @param documentAIEnum task execution type
     * @return CreateTaskResult
     */
    public CCreateTaskResult createTask(CDocumentAIEnum documentAIEnum){
        return this.createTask(documentAIEnum.getValue());
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId, String password) {
        return getUploadFileResult(file, taskId, password, null);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String password, String fileName) {
        return getUploadFileResult(file, taskId, password, null,fileName);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String password, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, null,fileName);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, String password) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, null,file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId) {
        return getUploadFileResult(file, taskId, null, null);
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String fileName) {
        return getUploadFileResult(file, taskId, null, null,fileName);
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, null,fileName);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, null,file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId, String password, CFileParameter CFileParameter) {
        return getUploadFileResult(file, taskId, password, CFileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String password, CFileParameter CFileParameter, String fileName) {
        return getUploadFileResult(file, taskId, password, CFileParameter,fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String password, CFileParameter CFileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, CFileParameter,fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, String password, CFileParameter CFileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, CFileParameter,file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId, CFileParameter CFileParameter) {
        return getUploadFileResult(file, taskId, null, CFileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, CFileParameter CFileParameter, String fileName) {
        return getUploadFileResult(file, taskId, null, CFileParameter,fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(URL file, String taskId, CFileParameter CFileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, CFileParameter,fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param CFileParameter fileParameter
     * @return UploadFileResult
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, CFileParameter CFileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, CFileParameter,file.getOriginalFilename());
    }

    private CUploadFileResult getUploadFileResult(File file, String taskId, String password, CFileParameter CFileParameter) {
        return httpClient.getUploadFileResult(file, taskId, password, CFileParameter);
    }

    private CUploadFileResult getUploadFileResult(InputStream file, String taskId, String password, CFileParameter CFileParameter, String fileName) {
        return httpClient.getUploadFileResult(file, taskId, password, CFileParameter,fileName);
    }

//    private UploadFileResult getUploadFileResult(URL file, String taskId, String password, FileParameter fileParameter,String fileName) throws IOException {
//        return httpClient.getUploadFileResult(file.openConnection().getInputStream(), taskId, password, fileParameter,fileName);
//    }


    /**
     * executeTask
     *
     * @param taskId taskId
     * @return CreateTaskResult
     */
    public CCreateTaskResult executeTask(String taskId) {
        return httpClient.executeTask(taskId);
    }

    /**
     * Query task file status
     *
     * @param taskId taskId
     * @return QueryTaskInfoResult
     */
    public CTaskInfoResult getTaskInfo(String taskId) {
        return httpClient.queryTaskInfo(taskId);
    }


}
