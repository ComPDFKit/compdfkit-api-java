//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.enums;

public enum COfficeToPDFEnum {

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
    RTF_TO_PDF("rtf/pdf");

    private final String value;

    COfficeToPDFEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static COfficeToPDFEnum getInstance(String value) {
        for (COfficeToPDFEnum pdfToOfficeEnum : values()) {
            if (pdfToOfficeEnum.value.equals(value)) {
                return pdfToOfficeEnum;
            }
        }
        return null;
    }


}
