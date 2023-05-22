//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo;

import cn.kdan.compdfkit.constant.CommonConstant;
import cn.kdan.compdfkit.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class ResultMap<T> {
    private int code;
    private String msg;
    private T result;

    public ResultMap() {
        code = CommonConstant.SUCCESS;
        msg = CommonConstant.RESULT_SUCCESS;
    }

    public ResultMap(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMap(int code, String msg, T result) {
        super();
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultMap<?> resultMap = (ResultMap<?>) o;
        return code == resultMap.code &&
                Objects.equals(msg, resultMap.msg) &&
                Objects.equals(result, resultMap.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, result);
    }


    @Override
    public String toString() {
        return JsonUtils.getJsonString(this);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == CommonConstant.SUCCESS;
    }
}
