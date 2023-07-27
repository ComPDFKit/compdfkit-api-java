//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.client;


import com.compdfkit.enums.CPDFDocumentAIEnum;
import com.compdfkit.enums.CPDFConversionEnum;
import com.compdfkit.enums.CPDFDocumentEditorEnum;
import com.compdfkit.param.CPDFFileParameter;
import com.compdfkit.pojo.comPdfKit.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.List;

import static java.time.Duration.ofSeconds;

/**
 * For execution ComPDFKit API
 */
public class CPDFClient {

    /**
     * httpClient
     */
    private final CPDFHttpClient httpClient;

    /**
     * ComPDFKitClient
     *
     * @param publicKey your publicKey
     * @param secretKey your secretKey
     */
    public CPDFClient(String publicKey, String secretKey) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setConnectTimeout(ofSeconds(60 * 5));
        restTemplateBuilder.setBufferRequestBody(false);
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        httpClient = new CPDFHttpClient(restTemplate, publicKey, secretKey);
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
    public CPDFClient(String publicKey, String secretKey, Long readTimeout, Long connectTimeout) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(ofSeconds(readTimeout));
        restTemplateBuilder.setConnectTimeout(ofSeconds(connectTimeout));
        restTemplateBuilder.setBufferRequestBody(false);
        RestTemplate restTemplate = restTemplateBuilder
                .build();
        httpClient = new CPDFHttpClient(restTemplate, publicKey, secretKey);
        httpClient.refreshAccessToken();
    }

    /**
     * get token
     *
     * @param publicKey publicKey
     * @param secretKey secretKey
     * @return CPDFOauthResult
     */
    private CPDFOauthResult getComPdfKitAuth(String publicKey, String secretKey) {
        return httpClient.getComPdfKitAuth(publicKey, secretKey);
    }

    /**
     * get Support tools
     *
     * @return CPDFTool
     */
    public List<CPDFTool> getTools() {
        return httpClient.getTools();
    }

    /**
     * get file info
     *
     * @param fileKey fileKey
     * @return CPDFFileInfo
     */
    public CPDFFileInfo getFileInfo(String fileKey) {
        return httpClient.getFileInfo(fileKey);
    }

    /**
     * get asset info
     *
     * @return CPDFTenantAssetResult
     */
    public CPDFTenantAssetResult getAssetInfo() {
        return httpClient.getAssetInfo();
    }

    /**
     * get task list
     *
     * @param page page
     * @param size size
     * @return CPDFTaskRecordsResult
     */
    public CPDFTaskRecordsResult getTaskList(String page, String size) {
        return httpClient.getTaskList(page, size);
    }


    /**
     * createTask
     *
     * @param executeTypeUrl task execution type
     * @return CPDFCreateTaskResult
     */
    public CPDFCreateTaskResult createTask(String executeTypeUrl) {
        return httpClient.createTask(executeTypeUrl);
    }

    /**
     * createTask
     *
     * @param conversionEnum task execution type
     * @return CPDFCreateTaskResult
     */
    public CPDFCreateTaskResult createTask(CPDFConversionEnum conversionEnum) {
        return this.createTask(conversionEnum.getValue());
    }

    /**
     * createTask
     *
     * @param documentEditorEnum task execution type
     * @return CPDFCreateTaskResult
     */
    public CPDFCreateTaskResult createTask(CPDFDocumentEditorEnum documentEditorEnum) {
        return this.createTask(documentEditorEnum.getValue());
    }

    /**
     * createTask
     *
     * @param documentAIEnum task execution type
     * @return CPDFCreateTaskResult
     */
    public CPDFCreateTaskResult createTask(CPDFDocumentAIEnum documentAIEnum) {
        return this.createTask(documentAIEnum.getValue());
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, String password) {
        return getUploadFileResult(file, taskId, password, null);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @param fileName fileName
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, String password, String fileName) {
        return getUploadFileResult(file, taskId, password, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     fileUrl
     * @param taskId   taskId
     * @param password password
     * @param fileName fileName
     * @return CPDFUploadFileResult
     * @throws IOException url openConnection error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, String password, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param password password
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, String password) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, null, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId) {
        return getUploadFileResult(file, taskId, null, null);
    }

    /**
     * uploadFile
     *
     * @param file     file
     * @param taskId   taskId
     * @param fileName fileName
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, String fileName) {
        return getUploadFileResult(file, taskId, null, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file     fileUrl
     * @param taskId   taskId
     * @param fileName fileName
     * @return CPDFUploadFileResult
     * @throws IOException url openConnection error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, null, fileName);
    }

    /**
     * uploadFile
     *
     * @param file   file
     * @param taskId taskId
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, null, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, String password, CPDFFileParameter fileParameter) {
        return getUploadFileResult(file, taskId, password, fileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws FileNotFoundException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, String password, CPDFFileParameter fileParameter, File imageFile) throws FileNotFoundException {
        return getUploadFileResult(file, taskId, password, fileParameter, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, String password, CPDFFileParameter fileParameter, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file, taskId, password, fileParameter, imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, String password, CPDFFileParameter fileParameter, String fileName) {
        return getUploadFileResult(file, taskId, password, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws FileNotFoundException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, String password, CPDFFileParameter fileParameter, String fileName, File imageFile) throws FileNotFoundException {
        return getUploadFileResult(file, taskId, password, fileParameter, fileName, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, String password, CPDFFileParameter fileParameter, String fileName, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file, taskId, password, fileParameter, fileName, imageFile.openConnection().getInputStream(), imageFileName);
    }


    /**
     * uploadFile
     *
     * @param file          fileUrl
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CPDFUploadFileResult
     * @throws IOException url openConnection error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, String password, CPDFFileParameter fileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, String password, CPDFFileParameter fileParameter, String fileName, File imageFile) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, fileParameter, fileName, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, String password, CPDFFileParameter fileParameter, String fileName, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, password, fileParameter, fileName, imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, String password, CPDFFileParameter fileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, fileParameter, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, String password, CPDFFileParameter fileParameter, File imageFile) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, fileParameter, file.getOriginalFilename(), new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, String password, CPDFFileParameter fileParameter, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, password, fileParameter, file.getOriginalFilename(), imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, CPDFFileParameter fileParameter) {
        return getUploadFileResult(file, taskId, null, fileParameter);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, CPDFFileParameter fileParameter, File imageFile) throws IOException {
        return getUploadFileResult(file, taskId, null, fileParameter, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(File file, String taskId, CPDFFileParameter fileParameter, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file, taskId, null, fileParameter, imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CPDFUploadFileResult
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, CPDFFileParameter fileParameter, String fileName) {
        return getUploadFileResult(file, taskId, null, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, CPDFFileParameter fileParameter, String fileName, File imageFile) throws IOException {
        return getUploadFileResult(file, taskId, null, fileParameter, fileName, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param fileName      fileName
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(InputStream file, String taskId, CPDFFileParameter fileParameter, String fileName, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file, taskId, null, fileParameter, fileName, imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CPDFUploadFileResult
     * @throws IOException url openConnection error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, CPDFFileParameter fileParameter, String fileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, fileParameter, fileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, CPDFFileParameter fileParameter, String fileName, File imageFile) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, fileParameter, fileName, new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param fileName      fileName
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(URL file, String taskId, CPDFFileParameter fileParameter, String fileName, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file.openConnection().getInputStream(), taskId, null, fileParameter, fileName, imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, CPDFFileParameter fileParameter) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, fileParameter, file.getOriginalFilename());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, CPDFFileParameter fileParameter, File imageFile) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, fileParameter, file.getOriginalFilename(), new FileInputStream(imageFile), imageFile.getName());
    }

    /**
     * uploadFile
     *
     * @param file          file
     * @param taskId        taskId
     * @param fileParameter fileParameter
     * @param imageFile     imageFile
     * @param imageFileName imageFileName
     * @return CPDFUploadFileResult
     * @throws IOException file getInputStream error
     */
    public CPDFUploadFileResult uploadFile(MultipartFile file, String taskId, CPDFFileParameter fileParameter, URL imageFile, String imageFileName) throws IOException {
        return getUploadFileResult(file.getInputStream(), taskId, null, fileParameter, file.getOriginalFilename(), imageFile.openConnection().getInputStream(), imageFileName);
    }

    /**
     * getUploadFileResult
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @return CPDFUploadFileResult
     */
    private CPDFUploadFileResult getUploadFileResult(File file, String taskId, String password, CPDFFileParameter fileParameter) {
        return httpClient.getUploadFileResult(file, taskId, password, fileParameter);
    }

    /**
     * getUploadFileResult
     *
     * @param file             file
     * @param taskId           taskId
     * @param password         password
     * @param fileParameter    fileParameter
     * @param imageInputStream imageInputStream
     * @param imageFileName    imageFileName
     * @return CPDFUploadFileResult
     * @throws FileNotFoundException file getInputStream error
     */
    private CPDFUploadFileResult getUploadFileResult(File file, String taskId, String password, CPDFFileParameter fileParameter, InputStream imageInputStream, String imageFileName) throws FileNotFoundException {
        return httpClient.getUploadFileResult(new FileInputStream(file), taskId, password, fileParameter, file.getName(), imageInputStream, imageFileName);
    }

    /**
     * getUploadFileResult
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param fileName      fileName
     * @return CPDFUploadFileResult
     */
    private CPDFUploadFileResult getUploadFileResult(InputStream file, String taskId, String password, CPDFFileParameter fileParameter, String fileName) {
        return httpClient.getUploadFileResult(file, taskId, password, fileParameter, fileName, null, null);
    }

    /**
     * getUploadFileResult
     *
     * @param file             file
     * @param taskId           taskId
     * @param password         password
     * @param fileParameter    fileParameter
     * @param fileName         fileName
     * @param imageInputStream imageInputStream
     * @param imageFileName    imageFileName
     * @return CPDFUploadFileResult
     */
    private CPDFUploadFileResult getUploadFileResult(InputStream file, String taskId, String password, CPDFFileParameter fileParameter, String fileName, InputStream imageInputStream, String imageFileName) {
        return httpClient.getUploadFileResult(file, taskId, password, fileParameter, fileName, imageInputStream, imageFileName);
    }

    /**
     * executeTask
     *
     * @param taskId taskId
     * @return CPDFCreateTaskResult
     */
    public CPDFCreateTaskResult executeTask(String taskId) {
        return httpClient.executeTask(taskId);
    }

    /**
     * get task file info
     *
     * @param taskId taskId
     * @return CPDFTaskInfoResult
     */
    public CPDFTaskInfoResult getTaskInfo(String taskId) {
        return httpClient.getTaskInfo(taskId);
    }


}
