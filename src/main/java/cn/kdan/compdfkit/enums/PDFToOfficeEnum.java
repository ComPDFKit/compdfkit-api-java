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
public enum PDFToOfficeEnum {

    PDF_TO_WORD("pdf/docx"),
    PDF_TO_EXCEL("pdf/xlsx"),
    PDF_TO_PPT("pdf/pptx"),
    PDF_TO_TXT("pdf/txt"),
    PDF_TO_PNG("pdf/png"),
    PDF_TO_JPG("pdf/jpg"),
    PDF_TO_HTML("pdf/html"),
    PDF_TO_RTF("pdf/rtf"),
    PDF_TO_CSV("pdf/csv");

    private final String value;

    public static PDFToOfficeEnum getInstance(String value) {
        for (PDFToOfficeEnum pdfToOfficeEnum : values()) {
            if (pdfToOfficeEnum.value.equals(value)) {
                return pdfToOfficeEnum;
            }
        }
        return null;
    }


}
