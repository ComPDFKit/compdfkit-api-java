//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.enums;

public enum CPDFDocumentEditorEnum {

    SPLIT("pdf/split"),
    MERGE("pdf/merge"),
    COMPRESS("pdf/compress"),
    DELETE("pdf/delete"),
    EXTRACT("pdf/extract"),
    ROTATION("pdf/rotation"),
    INSERT("pdf/insert"),
    ADD_WATERMARK("pdf/addWatermark"),
    DEL_WATERMARK("pdf/delWatermark"),
    PDF_CONTENT_COMPARE("pdf/contentCompare"),
    PDF_COVER_COMPARE("pdf/coverCompare"),
    ;
    private final String value;

    CPDFDocumentEditorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CPDFDocumentEditorEnum getInstance(String value) {
        for (CPDFDocumentEditorEnum pdfServerEnum : values()) {
            if (pdfServerEnum.value.equals(value)) {
                return pdfServerEnum;
            }
        }
        return null;
    }


}
