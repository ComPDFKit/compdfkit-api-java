//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.exception;

import cn.kdan.compdfkit.constant.CommonConstant;
import cn.kdan.compdfkit.pojo.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultMap handlerArgumentCheck(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder(CommonConstant.PARAMS_MISSING_ERROR);
        for (FieldError fieldError : fieldErrorList) {
            sb.append(fieldError.getField()).append(CommonConstant.STRING_SIGN_COLON);
            sb.append(fieldError.getDefaultMessage()).append(CommonConstant.STRING_SIGN_PERIOD);
        }

        return new ResultMap(CommonConstant.EXCEPTION_CODE_PARAMETERS_ERROR, sb.toString());
    }

    @ExceptionHandler(BackendRuntimeException.class)
    @ResponseBody
    public ResultMap handlerRuntimeException(BackendRuntimeException e) {
        logger.error("业务异常:" + e.getMessage(), e);
        if (!ObjectUtils.isEmpty(e.getCode())) {
            return new ResultMap(e.getCode(), e.getMessage());
        }
        return new ResultMap(CommonConstant.EXCEPTION_CODE_RUNTIME_ERROR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultMap handlerException(Exception e) {
        logger.info("错误信息:" + e.getMessage(), e);
        return new ResultMap(CommonConstant.EXCEPTION_CODE_SERVER_ERROR, "错误信息： " + e.getMessage());
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultMap handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.info(e.getMessage(), e);
        return new ResultMap(CommonConstant.EXCEPTION_CODE_SERVER_ERROR, "参数错误： " + e.getParameterName() + " 缺失");
    }

}
