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

/**
 * For execution ComPDFKit API
 */
public class ComPDFKitClient {

    /**
     * httpClient
     */
    private final CHttpClient httpClient;

    /**
     * ComPDFKitClient
     *
     * @param publicKey your publicKey
     * @param secretKey your secretKey
     */
    public ComPDFKitClient(String publicKey, String secretKey) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setConnectTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setBufferRequestBody(false);
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        httpClient = new CHttpClient(restTemplate, publicKey, secretKey);
        httpClient.refreshAccessToken();
    }

    /**
     * ComPDFKitClient
     *
     * @param publicKey      your publicKey
     * @param secretKey      your secretKey
     * @param readTimeout    readTimeout Seconds
     * @param connectTimeout connectTimeout Seconds
     */
    public ComPDFKitClient(String publicKey, String secretKey, Long readTimeout, Long connectTimeout) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(ofSeconds(readTimeout));
        restTemplateBuilder.setConnectTimeout(ofSeconds(connectTimeout));
        restTemplateBuilder.setBufferRequestBody(false);
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        httpClient = new CHttpClient(restTemplate, publicKey, secretKey);
        httpClient.refreshAccessToken();
    }

    /**
     * get token
     *
     * @param publicKey publicKey
     * @param secretKey secretKey
     * @return ComPdfKitOauthResult
     */
    private ComPdfKitOauthResult getComPdfKitAuth(String publicKey, String secretKey) {
        return httpClient.getComPdfKitAuth(publicKey, secretKey);
    }

    /**
     * get Support tools
     *
     * @return CTool
     */
    public List<CTool> getTools() {
        return httpClient.getTools();
    }

    /**
     * get file info
     *
     * @param fileKey fileKey
     * @return CFileInfo
     */
    public CFileInfo getFileInfo(String fileKey) {
        return httpClient.getFileInfo(fileKey);
    }

    /**
     * get asset info
     *
     * @return CTenantAssetResult
     */
    public CTenantAssetResult getAssetInfo() {
        return httpClient.getAssetInfo();
    }

    /**
     * get task list
     *
     * @param page page
     * @param size size
     * @return CTaskRecordsResult
     */
    public CTaskRecordsResult getTaskList(String page, String size) {
        return httpClient.getTaskList(page, size);
    }


    /**
     * createTask
     *
     * @param executeTypeUrl task execution type
     * @return CCreateTaskResult
     */
    public CCreateTaskResult createTask(String executeTypeUrl) {
        return httpClient.createTask(executeTypeUrl);
    }

    /**
     * createTask
     *
     * @param officeToPDFEnum task execution type
     * @return CCreateTaskResult
     */
    public CCreateTaskResult createTask(COfficeToPDFEnum officeToPDFEnum) {
        return this.createTask(officeToPDFEnum.getValue());
    }

    /**
     * createTask
     *
     * @param pdfServerEnum task execution type
     * @return CCreateTaskResult
     */
    public CCreateTaskResult createTask(CPDFServerEnum pdfServerEnum) {
        return this.createTask(pdfServerEnum.getValue());
    }

    /**
     * createTask
     *
     * @param pdfToOfficeEnum task execution type
     * @return CCreateTaskResult
     */
    public CCreateTaskResult createTask(CPDFToOfficeEnum pdfToOfficeEnum) {
        return this.createTask(pdfToOfficeEnum.getValue());
    }

    /**
     * createTask
     *
     * @param documentAIEnum task execution type
     * @return CCreateTaskResult
     */
    public CCreateTaskResult createTask(CDocumentAIEnum documentAIEnum) {
        return this.createTask(documentAIEnum.getValue());
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return CUploadFileResult
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
     * @param fileName fileName
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String password, String fileName) {
        return getUploadFileResult(file, taskId, password, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     fileUrl
     * @param taskId   taskId
     * @param password password
     * @param fileName fileName
     * @return CUploadFileResult
     * @throws IOException url openConnection error
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String password, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return CUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, String password) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, null, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId) {
        return getUploadFileResult(file, taskId, null, null);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param fileName fileName
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String fileName) {
        return getUploadFileResult(file, taskId, null, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     fileUrl
     * @param taskId   taskId
     * @param fileName fileName
     * @return CUploadFileResult
     * @throws IOException url openConnection error
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return CUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, null, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId, String password, CFileParameter fileParameter) {
        return getUploadFileResult(file, taskId, password, fileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, String password, CFileParameter fileParameter, String fileName) {
        return getUploadFileResult(file, taskId, password, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          fileUrl
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CUploadFileResult
     * @throws IOException url openConnection error
     */
    public CUploadFileResult uploadFile(URL file, String taskId, String password, CFileParameter fileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, String password, CFileParameter fileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, fileParameter, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(File file, String taskId, CFileParameter fileParameter) {
        return getUploadFileResult(file, taskId, null, fileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CUploadFileResult
     */
    public CUploadFileResult uploadFile(InputStream file, String taskId, CFileParameter fileParameter, String fileName) {
        return getUploadFileResult(file, taskId, null, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CUploadFileResult
     * @throws IOException url openConnection error
     */
    public CUploadFileResult uploadFile(URL file, String taskId, CFileParameter fileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @return CUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CUploadFileResult uploadFile(MultipartFile file, String taskId, CFileParameter fileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, fileParameter, file.getOriginalFilename());
    }

    /**
     * getUploadFileResult
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CUploadFileResult
     */
    private CUploadFileResult getUploadFileResult(File file, String taskId, String password, CFileParameter fileParameter) {
        return httpClient.getUploadFileResult(file, taskId, password, fileParameter);
    }

    /**
     * getUploadFileResult
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CUploadFileResult
     */
    private CUploadFileResult getUploadFileResult(InputStream file, String taskId, String password, CFileParameter fileParameter, String fileName) {
        return httpClient.getUploadFileResult(file, taskId, password, fileParameter, fileName);
    }

    /**
     * executeTask
     *
     * @param taskId taskId
     * @return CCreateTaskResult
     */
    public CCreateTaskResult executeTask(String taskId) {
        return httpClient.executeTask(taskId);
    }

    /**
     * get task file info
     *
     * @param taskId taskId
     * @return CTaskInfoResult
     */
    public CTaskInfoResult getTaskInfo(String taskId) {
        return httpClient.getTaskInfo(taskId);
    }


}
