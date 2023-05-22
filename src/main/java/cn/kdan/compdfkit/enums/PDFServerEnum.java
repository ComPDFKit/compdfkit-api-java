//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum PDFServerEnum {

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

    public static PDFServerEnum getInstance(String value) {
        for (PDFServerEnum pdfServerEnum : values()) {
            if (pdfServerEnum.value.equals(value)) {
                return pdfServerEnum;
            }
        }
        return null;
    }


}
