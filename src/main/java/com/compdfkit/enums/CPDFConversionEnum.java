//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.enums;

public enum  CPDFConversionEnum {

    DOC_TO_PDF("doc/pdf"),
    DOCX_TO_PDF("docx/pdf"),
    XLSX_TO_PDF("xlsx/pdf"),
    XLS_TO_PDF("xls/pdf"),
    PPT_TO_PDF("ppt/pdf"),
    PPTX_TO_PDF("pptx/pdf"),
    TXT_TO_PDF("txt/pdf"),
    PNG_TO_PDF("png/pdf"),
    HTML_TO_PDF("html/pdf"),
    CSV_TO_PDF("csv/pdf"),
    RTF_TO_PDF("rtf/pdf"),

    PDF_TO_WORD("pdf/docx"),
    PDF_TO_EXCEL("pdf/xlsx"),
    PDF_TO_PPT("pdf/pptx"),
    PDF_TO_TXT("pdf/txt"),
    PDF_TO_HTML("pdf/html"),
    PDF_TO_RTF("pdf/rtf"),
    PDF_TO_CSV("pdf/csv"),

    //img
    PDF_TO_PNG("pdf/png"),
    PDF_TO_JPG("pdf/jpg"),
    IMAGE_TO_WORD("img/docx"),
    IMAGE_TO_EXCEL("img/xlsx"),
    IMAGE_TO_PPT("img/pptx"),
    IMAGE_TO_TXT("img/txt"),
    IMAGE_TO_CSV("img/csv"),
    IMAGE_TO_HTML("img/html"),
    IMAGE_TO_RTF("img/rtf"),
    IMAGE_TO_JSON("img/json"),
    PDF_TO_JSON("pdf/json"),
    PDF_TO_EDITABLE("pdf/editable");


    private final String value;

    CPDFConversionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CPDFConversionEnum getInstance(String value) {
        for (CPDFConversionEnum pdfToOfficeEnum : values()) {
            if (pdfToOfficeEnum.value.equals(value)) {
                return pdfToOfficeEnum;
            }
        }
        return null;
    }


}
