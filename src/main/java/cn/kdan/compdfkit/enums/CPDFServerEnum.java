//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.enums;

public enum CPDFServerEnum {

    SPLIT("pdf/split"),
    MERGE("pdf/merge"),
    COMPRESS("pdf/compress"),
    DELETE("pdf/delete"),
    EXTRACT("pdf/extract"),
    ROTATION("pdf/rotation"),
    INSERT("pdf/insert"),
    ADD_WATERMARK("pdf/addWatermark"),
    DEL_WATERMARK("pdf/delWatermark");

    private final String value;

    CPDFServerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CPDFServerEnum getInstance(String value) {
        for (CPDFServerEnum pdfServerEnum : values()) {
            if (pdfServerEnum.value.equals(value)) {
                return pdfServerEnum;
            }
        }
        return null;
    }


}
