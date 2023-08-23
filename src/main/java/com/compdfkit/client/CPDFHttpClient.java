//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.client;

import com.alibaba.fastjson.JSON;
import com.compdfkit.constant.CPDFConstant;
import com.compdfkit.exception.CPDFException;
import com.compdfkit.param.CPDFFileParameter;
import com.compdfkit.pojo.comPdfKit.*;
import com.compdfkit.utils.CPDFJsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * HttpClient
 */
public class CPDFHttpClient {

    private final RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(CPDFHttpClient.class);
    private final String address;
    private long expireTime;
    private static String accessToken;
    private final String publicKey;
    private final String secretKey;

    /**
     * CHttpClient
     *
     * @param restTemplate restTemplate
     * @param publicKey    publicKey
     * @param secretKey    secretKey
     */
    CPDFHttpClient(RestTemplate restTemplate, String publicKey, String secretKey) {
        this.address = "https://api-server.compdf.com/server/";
        this.restTemplate = restTemplate;
        this.publicKey = publicKey;
        this.secretKey = secretKey;
        this.refreshAccessToken();
    }

    /**
     * basicHeaders
     *
     * @return HttpHeaders
     */
    private HttpHeaders basicHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + this.getAccessToken());
        return headers;
    }

    /**
     * getAccessToken
     *
     * @return toke
     */
    String getAccessToken() {
        if (ObjectUtils.isEmpty(expireTime) || System.currentTimeMillis() > expireTime) {
            refreshAccessToken();
        }
        return accessToken;
    }

    /**
     * setAccessToken
     *
     * @param token     token
     * @param expiresIn expiresIn
     */
    void setAccessToken(String token, long expiresIn) {
        accessToken = token;
        expireTime = System.currentTimeMillis() + expiresIn * 1000L;
    }

    /**
     * refreshAccessToken
     */
    void refreshAccessToken() {
        // Call the API to refresh the token
        CPDFOauthResult newToken = getComPdfKitAuth(this.publicKey, this.secretKey);
        setAccessToken(newToken.getAccessToken(), Long.parseLong(newToken.getExpiresIn()));
    }

    /**
     * getComPdfKitAuth
     *
     * @param publicKey publicKey
     * @param secretKey secretKey
     * @return ComPdfKitOauthResult
     */
    CPDFOauthResult getComPdfKitAuth(String publicKey, String secretKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> tokenParam = new HashMap<>();
        tokenParam.put("publicKey", publicKey);
        tokenParam.put("secretKey", secretKey);
        ResponseEntity<CPDFResult<CPDFOauthResult>> responseEntity;
        ParameterizedTypeReference<CPDFResult<CPDFOauthResult>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFOauthResult>>() {
        };
        try {
            responseEntity = restTemplate.exchange(
                    address.concat(CPDFConstant.API_V1_OAUTH_TOKEN),
                    HttpMethod.POST,
                    new HttpEntity<>(CPDFJsonUtils.getJsonString(tokenParam), headers),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_GET_TOKEN_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_GET_TOKEN_FAIL);
        }
        if (responseEntity.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(responseEntity.getBody()) || !responseEntity.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(responseEntity.getBody()).getCode(), responseEntity.getBody().getMsg());
        }
        return responseEntity.getBody().getData();
    }

    /**
     * getTools
     *
     * @return List<CTool>
     */
    List<CPDFTool> getTools() {
        String url = address.concat(CPDFConstant.API_V1_TOOL_SUPPORT);
        ResponseEntity<CPDFResult<List<CPDFTool>>> response;
        ParameterizedTypeReference<CPDFResult<List<CPDFTool>>> typeRef = new ParameterizedTypeReference<CPDFResult<List<CPDFTool>>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_QUERY_TOOLS_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_QUERY_TOOLS_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * getFileInfo
     *
     * @param fileKey  fileKey
     * @param language 1:English, 2:Chinese
     * @return CFileInfo
     */
    CPDFFileInfo getFileInfo(String fileKey, Integer language) {
        String url = address.concat(CPDFConstant.API_V1_FILE_INFO).concat("?fileKey=").concat(fileKey);
        if (Objects.nonNull(language)){
            url = url.concat("&language=").concat(String.valueOf(language));
        }
        ResponseEntity<CPDFResult<CPDFFileInfo>> response;
        ParameterizedTypeReference<CPDFResult<CPDFFileInfo>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFFileInfo>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_QUERY_FILE_INFO_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_QUERY_FILE_INFO_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * getAssetInfo
     *
     * @return CTenantAssetResult
     */
    CPDFTenantAssetResult getAssetInfo() {
        String url = address.concat(CPDFConstant.API_V1_ASSET_INFO);
        ResponseEntity<CPDFResult<CPDFTenantAssetResult>> response;
        ParameterizedTypeReference<CPDFResult<CPDFTenantAssetResult>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFTenantAssetResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_QUERY_TENANT_ASSET_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_QUERY_TENANT_ASSET_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * getTaskList
     *
     * @param page page
     * @param size size
     * @return CTaskRecordsResult
     */
    CPDFTaskRecordsResult getTaskList(String page, String size) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(size)) {
            size = "5";
        }
        String url = address.concat(CPDFConstant.API_V1_TASK_LIST).concat("?page=").concat(page).concat("&size=").concat(size);
        ResponseEntity<CPDFResult<CPDFTaskRecordsResult>> response;
        ParameterizedTypeReference<CPDFResult<CPDFTaskRecordsResult>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFTaskRecordsResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_QUERY_TASK_LIST_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_QUERY_TASK_LIST_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * createTask
     *
     * @param executeTypeUrl executeTypeUrl
     * @param language       1:English, 2:Chinese
     * @return CCreateTaskResult
     */
    CPDFCreateTaskResult createTask(String executeTypeUrl, Integer language) {
        String url = address.concat(CPDFConstant.API_V1_CREATE_TASK).replace("{executeTypeUrl}", executeTypeUrl);
        if (Objects.nonNull(language)){
            url = url.concat("&language=").concat(String.valueOf(language));
        }
        ResponseEntity<CPDFResult<CPDFCreateTaskResult>> response;
        ParameterizedTypeReference<CPDFResult<CPDFCreateTaskResult>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFCreateTaskResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_CREATE_TASK_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_CREATE_TASK_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(CPDFConstant.SUCCESS_CODE)) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * getUploadFileResult
     *
     * @param file          file
     * @param taskId        taskId
     * @param password      password
     * @param fileParameter fileParameter
     * @param language      1:English, 2:Chinese
     * @return CUploadFileResult
     */
    CPDFUploadFileResult getUploadFileResult(File file, String taskId, String password, CPDFFileParameter fileParameter, Integer language) {
        try {
            return this.getUploadFileResult(new FileInputStream(file), taskId, password, fileParameter, file.getName(), null, null, language);
        } catch (FileNotFoundException e) {
            throw new CPDFException(e.getMessage(), e);
        }
    }

    /**
     * getUploadFileResult
     *
     * @param fileInputStream  fileInputStream
     * @param taskId           taskId
     * @param password         password
     * @param fileParameter    fileParameter
     * @param fileName         fileName
     * @param imageInputStream imageFile
     * @param imageFileName    imageFileName
     * @param language         1:English, 2:Chinese
     * @return return CUploadFileResult
     */
    CPDFUploadFileResult getUploadFileResult(InputStream fileInputStream, String taskId, String password, CPDFFileParameter fileParameter, String fileName, InputStream imageInputStream, String imageFileName, Integer language) {
        log.info("Start uploading files, task Id: {}, password: {}", taskId, password);
        String url = address.concat(CPDFConstant.API_V1_UPLOAD_FILE);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream) {
            @Override
            public long contentLength() throws IOException {
                return fileInputStream.available();
            }

            @Override
            public String getFilename() {
                return fileName;
            }
        };
        param.add("file", inputStreamResource);
        param.add("taskId", taskId);
        if (Objects.nonNull(language)){
            param.add("language", language);
        }
        if (!StringUtils.isEmpty(password)) {
            param.add("password", password);
        }
        if (!ObjectUtils.isEmpty(fileParameter)) {
            param.add("parameter", JSON.toJSONString(fileParameter));
        }
        if (!ObjectUtils.isEmpty(imageInputStream) && !ObjectUtils.isEmpty(imageFileName)) {
            InputStreamResource imageInputStreamResource = new InputStreamResource(imageInputStream) {
                @Override
                public long contentLength() throws IOException {
                    return imageInputStream.available();
                }

                @Override
                public String getFilename() {
                    return imageFileName;
                }
            };
            param.add("image", imageInputStreamResource);
        }
        HttpHeaders headers = basicHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ResponseEntity<CPDFResult<CPDFUploadFileResult>> response = null;
        ParameterizedTypeReference<CPDFResult<CPDFUploadFileResult>> typeRef = new ParameterizedTypeReference<CPDFResult<CPDFUploadFileResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(param, headers),
                    typeRef
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_UPLOAD_FILE_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_UPLOAD_FILE_FAIL + e.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                log.error("Failed to delete file; {}", e.getMessage());
            }
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !CPDFConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * executeTask
     *
     * @param taskId   taskId
     * @param language 1:English, 2:Chinese
     * @return CCreateTaskResult
     */
    CPDFCreateTaskResult executeTask(String taskId, Integer language) {
        log.info("Start executing task transfer, taskId: {}", taskId);
        String url = address.concat(CPDFConstant.API_V1_EXECUTE_TASK).concat("?taskId=").concat(taskId);
        if (Objects.nonNull(language)){
            url = url.concat("&language=").concat(String.valueOf(language));
        }
        ResponseEntity<CPDFResult<CPDFCreateTaskResult>> response;
        ParameterizedTypeReference<CPDFResult<CPDFCreateTaskResult>> result = new ParameterizedTypeReference<CPDFResult<CPDFCreateTaskResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(CPDFJsonUtils.getJsonString(taskId), basicHeaders()),
                    result
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_EXECUTE_TASK_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_EXECUTE_TASK_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !CPDFConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    /**
     * getTaskInfo
     *
     * @param taskId   taskId
     * @param language 1:English, 2:Chinese
     * @return CTaskInfoResult
     */
    CPDFTaskInfoResult getTaskInfo(String taskId, Integer language) {
        log.info("Start to query the transfer status, taskId: {}", taskId);
        String url = address.concat(CPDFConstant.API_V1_TASK_INFO).concat("?taskId=").concat(taskId);
        if (Objects.nonNull(language)){
            url = url.concat("&language=").concat(String.valueOf(language));
        }
        ResponseEntity<CPDFResult<CPDFTaskInfoResult>> response;
        ParameterizedTypeReference<CPDFResult<CPDFTaskInfoResult>> result = new ParameterizedTypeReference<CPDFResult<CPDFTaskInfoResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(CPDFJsonUtils.getJsonString(taskId), basicHeaders()),
                    result
            );
        } catch (Exception e) {
            log.error(CPDFConstant.EXCEPTION_MSG_TASK_INFO_FAIL + "{}", e.getMessage());
            throw new CPDFException(CPDFConstant.EXCEPTION_MSG_TASK_INFO_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !CPDFConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new CPDFException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        log.info("Query status succeeded: {}", CPDFJsonUtils.getJsonString(response.getBody().getData()));
        return response.getBody().getData();
    }

}
