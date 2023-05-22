//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.exception;


public class BackendRuntimeException extends RuntimeException {
    private Integer code;

    public BackendRuntimeException() {
        super();
    }

    public BackendRuntimeException(String message) {
        super(message);
    }

    public BackendRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BackendRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BackendRuntimeException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
