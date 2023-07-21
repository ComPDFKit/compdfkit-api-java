//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.client;

import cn.kdan.compdfkit.constant.ComPDFKitConstant;
import cn.kdan.compdfkit.exception.ComPDFKitException;
import cn.kdan.compdfkit.param.CFileParameter;
import cn.kdan.compdfkit.pojo.comPdfKit.*;
import cn.kdan.compdfkit.utils.CJsonUtils;
import com.alibaba.fastjson.JSON;
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


public class CHttpClient {

    private final RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(CHttpClient.class);
    private final String address;
    private long expireTime;
    private static String accessToken;
    private final String publicKey;
    private final String secretKey;

    CHttpClient(RestTemplate restTemplate, String publicKey, String secretKey){
        this.address = "https://api-server.compdf.com/server/";
        this.restTemplate = restTemplate;
        this.publicKey = publicKey;
        this.secretKey = secretKey;
        this.refreshAccessToken();
    }

    private HttpHeaders basicHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + this.getAccessToken());
        return headers;
    }

    public String getAccessToken() {
        if (ObjectUtils.isEmpty(expireTime) || System.currentTimeMillis() > expireTime) {
            refreshAccessToken();
        }
        return accessToken;
    }

    public void setAccessToken(String token, long expiresIn) {
        accessToken = token;
        expireTime = System.currentTimeMillis() + expiresIn * 1000L;
    }

    void refreshAccessToken() {
        // Call the API to refresh the token
        ComPdfKitOauthResult newToken = getComPdfKitAuth(this.publicKey, this.secretKey);
        setAccessToken(newToken.getAccessToken(), Long.parseLong(newToken.getExpiresIn()));
    }


    ComPdfKitOauthResult getComPdfKitAuth(String publicKey, String secretKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> tokenParam = new HashMap<>();
        tokenParam.put("publicKey", publicKey);
        tokenParam.put("secretKey", secretKey);
        ResponseEntity<ComPdfKitResult<ComPdfKitOauthResult>> responseEntity;
        ParameterizedTypeReference<ComPdfKitResult<ComPdfKitOauthResult>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<ComPdfKitOauthResult>>() {
        };
        try {
            responseEntity = restTemplate.exchange(
                    address.concat(ComPDFKitConstant.API_V1_OAUTH_TOKEN),
                    HttpMethod.POST,
                    new HttpEntity<>(CJsonUtils.getJsonString(tokenParam), headers),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_GET_TOKEN_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_GET_TOKEN_FAIL);
        }
        if (responseEntity.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(responseEntity.getBody()) || !responseEntity.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(responseEntity.getBody()).getCode(), responseEntity.getBody().getMsg());
        }
        return responseEntity.getBody().getData();
    }

    List<CTool> getTools() {
        String url = address.concat(ComPDFKitConstant.API_V1_TOOL_SUPPORT);
        ResponseEntity<ComPdfKitResult<List<CTool>>> response;
        ParameterizedTypeReference<ComPdfKitResult<List<CTool>>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<List<CTool>>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TOOLS_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TOOLS_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CFileInfo queryFileInfo(String fileKey) {
        String url = address.concat(ComPDFKitConstant.API_V1_FILE_INFO).concat("?fileKey=").concat(fileKey);
        ResponseEntity<ComPdfKitResult<CFileInfo>> response;
        ParameterizedTypeReference<ComPdfKitResult<CFileInfo>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<CFileInfo>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_QUERY_FILE_INFO_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_QUERY_FILE_INFO_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CTenantAssetResult queryAssetInfo() {
        String url = address.concat(ComPDFKitConstant.API_V1_ASSET_INFO);
        ResponseEntity<ComPdfKitResult<CTenantAssetResult>> response;
        ParameterizedTypeReference<ComPdfKitResult<CTenantAssetResult>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<CTenantAssetResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TENANT_ASSET_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TENANT_ASSET_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CTaskRecordsResult queryTaskList(String page, String size) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(size)) {
            size = "5";
        }
        String url = address.concat(ComPDFKitConstant.API_V1_TASK_LIST).concat("?page=").concat(page).concat("&size=").concat(size);
        ResponseEntity<ComPdfKitResult<CTaskRecordsResult>> response;
        ParameterizedTypeReference<ComPdfKitResult<CTaskRecordsResult>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<CTaskRecordsResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TASK_LIST_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_QUERY_TASK_LIST_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CCreateTaskResult createTask(String executeTypeUrl) {
        String url = address.concat(ComPDFKitConstant.API_V1_CREATE_TASK).replace("{executeTypeUrl}", executeTypeUrl);
        ResponseEntity<ComPdfKitResult<CCreateTaskResult>> response;
        ParameterizedTypeReference<ComPdfKitResult<CCreateTaskResult>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<CCreateTaskResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(basicHeaders()),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_CREATE_TASK_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_CREATE_TASK_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !response.getBody().getCode().equals(ComPDFKitConstant.SUCCESS_CODE)) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CUploadFileResult getUploadFileResult(File file, String taskId, String password, CFileParameter CFileParameter) {
        try {
            return this.getUploadFileResult(new FileInputStream(file),taskId,password, CFileParameter,file.getName());
        } catch (FileNotFoundException e) {
            throw new ComPDFKitException(e.getMessage(),e);
        }
    }

    CUploadFileResult getUploadFileResult(InputStream fileInputStream, String taskId, String password, CFileParameter CFileParameter, String fileName) {
        log.info("Start uploading files, task Id: {}, password: {}", taskId, password);
        String url = address.concat(ComPDFKitConstant.API_V1_UPLOAD_FILE);
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
        if (!StringUtils.isEmpty(password)) {
            param.add("password", password);
        }
        if (!ObjectUtils.isEmpty(CFileParameter)) {
            param.add("parameter", JSON.toJSONString(CFileParameter));
        }
        HttpHeaders headers = basicHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ResponseEntity<ComPdfKitResult<CUploadFileResult>> response = null;
        ParameterizedTypeReference<ComPdfKitResult<CUploadFileResult>> typeRef = new ParameterizedTypeReference<ComPdfKitResult<CUploadFileResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(param, headers),
                    typeRef
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_UPLOAD_FILE_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_UPLOAD_FILE_FAIL + e.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                log.error("Failed to delete file; {}", e.getMessage());
            }
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !ComPDFKitConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }


    CCreateTaskResult executeTask(String taskId) {
        log.info("Start executing task transfer, taskId: {}", taskId);
        String url = address.concat(ComPDFKitConstant.API_V1_EXECUTE_TASK).concat("?taskId=").concat(taskId);
        ResponseEntity<ComPdfKitResult<CCreateTaskResult>> response;
        ParameterizedTypeReference<ComPdfKitResult<CCreateTaskResult>> result = new ParameterizedTypeReference<ComPdfKitResult<CCreateTaskResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(CJsonUtils.getJsonString(taskId), basicHeaders()),
                    result
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_EXECUTE_TASK_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_EXECUTE_TASK_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !ComPDFKitConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        return response.getBody().getData();
    }

    CTaskInfoResult queryTaskInfo(String taskId) {
        log.info("Start to query the transfer status, taskId: {}", taskId);
        String url = address.concat(ComPDFKitConstant.API_V1_TASK_INFO).concat("?taskId=").concat(taskId);
        ResponseEntity<ComPdfKitResult<CTaskInfoResult>> response;
        ParameterizedTypeReference<ComPdfKitResult<CTaskInfoResult>> result = new ParameterizedTypeReference<ComPdfKitResult<CTaskInfoResult>>() {
        };
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<>(CJsonUtils.getJsonString(taskId), basicHeaders()),
                    result
            );
        } catch (Exception e) {
            log.error(ComPDFKitConstant.EXCEPTION_MSG_TASK_INFO_FAIL + "{}", e.getMessage());
            throw new ComPDFKitException(ComPDFKitConstant.EXCEPTION_MSG_TASK_INFO_FAIL + e.getMessage());
        }
        if (response.getStatusCode() != HttpStatus.OK || ObjectUtils.isEmpty(response.getBody()) || !ComPDFKitConstant.SUCCESS_CODE.equals(response.getBody().getCode())) {
            throw new ComPDFKitException(Objects.requireNonNull(response.getBody()).getCode(), response.getBody().getMsg());
        }
        log.info("Query status succeeded: {}", CJsonUtils.getJsonString(response.getBody().getData()));
        return response.getBody().getData();
    }

}
