//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.enums;

public enum CPDFDocumentAIEnum {

    OCR("documentAI/ocr"),
    MAGICCOLOR("documentAI/magicColor"),
    TABLEREC("documentAI/tableRec"),
    LAYOUTANALYSIS("documentAI/layoutAnalysis"),
    DEWARP("documentAI/dewarp"),
    DETECTIONSTAMP("documentAI/detectionStamp"),
    ;

    private final String value;

    CPDFDocumentAIEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CPDFDocumentAIEnum getInstance(String value) {
        for (CPDFDocumentAIEnum pdfServerEnum : values()) {
            if (pdfServerEnum.value.equals(value)) {
                return pdfServerEnum;
            }
        }
        return null;
    }


}
