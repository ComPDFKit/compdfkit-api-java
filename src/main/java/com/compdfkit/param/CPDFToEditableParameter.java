//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFToEditableParameter extends CPDFFileParameter {
    public static final String IS_ALLOW_OCR = "1";
    public static final String NOT_ALLOW_OCR = "0";
    public static final String IS_CONTAIN_OCR_BG = "1";
    public static final String NOT_CONTAIN_OCR_BG = "0";

    private String isAllowOcr;

    private String isContainOcrBg;

    private Integer lang;

    public String getIsAllowOcr() {
        return isAllowOcr;
    }

    public void setIsAllowOcr(String isAllowOcr) {
        this.isAllowOcr = isAllowOcr;
    }

    public String getIsContainOcrBg() {
        return isContainOcrBg;
    }

    public void setIsContainOcrBg(String isContainOcrBg) {
        this.isContainOcrBg = isContainOcrBg;
    }

    public Integer getLang() {
        return lang;
    }

    public void setLang(Integer lang) {
        this.lang = lang;
    }
}
