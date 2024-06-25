//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.constant;


public interface CPDFConstant {

    String API_V1_OAUTH_TOKEN = "v1/oauth/token";

    String API_V1_CREATE_TASK = "v1/task/{executeTypeUrl}";

    String API_V1_TOOL_SUPPORT = "v1/tool/support";

    String API_V1_FILE_INFO = "v1/file/fileInfo";

    String API_V1_ASSET_INFO = "v1/asset/info";
    String API_V1_TASK_LIST = "v1/task/list";

    String API_V1_UPLOAD_FILE = "v1/file/upload";

    String API_V1_EXECUTE_TASK = "v1/execute/start";

    String API_V1_TASK_INFO = "v1/task/taskInfo";

    String COM_PDF_KIT_TOKEN = "ComPDFKit_AccessToken";

    String EXCEPTION_MSG_GET_TOKEN_FAIL = "Failed to get ComPDFKit Token: ";

    String EXCEPTION_MSG_CREATE_TASK_FAIL = "Saas task creation failed: ";

    String EXCEPTION_MSG_UPLOAD_FILE_FAIL = "Saas upload file failed: ";

    String EXCEPTION_MSG_EXECUTE_TASK_FAIL = "Saas file conversion failed: ";

    String EXCEPTION_MSG_TASK_INFO_FAIL = "Failed to query saas file status: ";
    String EXCEPTION_MSG_QUERY_FILE_INFO_FAIL = "Saas query file info failed: ";
    String EXCEPTION_MSG_QUERY_TOOLS_FAIL = "Saas query tools  failed: ";
    String EXCEPTION_MSG_QUERY_TENANT_ASSET_FAIL = "Saas query tenant asset failed: ";
    String EXCEPTION_MSG_QUERY_TASK_LIST_FAIL = "";


    String SUCCESS_CODE = "200";
    int SUCCESS = 200;
    String RESULT_SUCCESS = "success";
    String STRING_SIGN_PERIOD = ".";
    String STRING_SIGN_COLON = ":";
    String PARAMS_MISSING_ERROR = "Missing required parameter!";
    String TASK_FINISH = "TaskFinish";
    int EXCEPTION_CODE_PARAMETERS_ERROR = 300;
    int EXCEPTION_CODE_SERVER_ERROR = 500;
    int EXCEPTION_CODE_RUNTIME_ERROR = 700;
}
