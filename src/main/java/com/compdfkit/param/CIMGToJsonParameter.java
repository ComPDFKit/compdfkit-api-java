//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CIMGToJsonParameter extends CPDFFileParameter {
    public static final String IS_ALLOW_OCR = "1";
    public static final String NOT_ALLOW_OCR = "0";
    public static final String IS_ONLY_AI_TABLE = "1";
    public static final String NOT_ONLY_AI_TABLE = "0";
    public static final String TYPE_TEXT = "0";
    public static final String TYPE_TABLE = "1";
    public static final String TYPE_CONTENT_EXTRACTION = "2";

    private String isAllowOcr;

    private String isOnlyAiTable;

    /**
     * 0 TEXT 1 TABLE 2 CONTENT EXTRACTION
     */
    private Integer type;

    public String getIsAllowOcr() {
        return isAllowOcr;
    }

    public void setIsAllowOcr(String isAllowOcr) {
        this.isAllowOcr = isAllowOcr;
    }

    public String getIsOnlyAiTable() {
        return isOnlyAiTable;
    }

    public void setIsOnlyAiTable(String isOnlyAiTable) {
        this.isOnlyAiTable = isOnlyAiTable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
