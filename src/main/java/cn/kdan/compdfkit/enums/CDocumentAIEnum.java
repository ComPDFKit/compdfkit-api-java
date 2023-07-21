//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.enums;

public enum CDocumentAIEnum {

    OCR("documentAI/ocr"),
    MAGICCOLOR("documentAI/magicColor"),
    TABLEREC("documentAI/tableRec"),
    LAYOUTANALYSIS("documentAI/layoutAnalysis"),
    DEWARP("documentAI/dewarp"),
    DETECTIONSTAMP("documentAI/detectionStamp"),
    ;

    private final String value;

    CDocumentAIEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CDocumentAIEnum getInstance(String value) {
        for (CDocumentAIEnum pdfServerEnum : values()) {
            if (pdfServerEnum.value.equals(value)) {
                return pdfServerEnum;
            }
        }
        return null;
    }


}
