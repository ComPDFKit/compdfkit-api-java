//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.exception;


public class ComPDFKitException extends RuntimeException {
    private String code;

    public ComPDFKitException() {
        super();
    }

    public ComPDFKitException(String message) {
        super(message);
    }

    public ComPDFKitException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ComPDFKitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComPDFKitException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
