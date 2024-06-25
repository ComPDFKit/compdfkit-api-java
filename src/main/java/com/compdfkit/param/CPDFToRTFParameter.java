//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFToRTFParameter extends CPDFFileParameter {

    public static final String IS_CONTAIN_ANNOT = "1";
    public static final String NOT_IS_CONTAIN_ANNOT = "0";
    public static final String IS_CONTAIN_IMG = "1";
    public static final String NOT_IS_CONTAIN_IMG = "0";

    public static final String IS_ALLOW_OCR = "1";
    public static final String NOT_ALLOW_OCR = "0";
    public static final String IS_CONTAIN_OCR_BG = "1";
    public static final String NOT_CONTAIN_OCR_BG = "0";
    /**
     * Typesetting method (1: flow layout, 0: box layout) Default box layout
     */
    private String isContainAnnot;

    /**
     * Whether to include pictures (1: yes, 0: no)
     */
    private String isContainImg;

    private String isAllowOcr;
    private String isContainOcrBg;

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

    public String getIsContainAnnot() {
        return isContainAnnot;
    }

    public void setIsContainAnnot(String isContainAnnot) {
        this.isContainAnnot = isContainAnnot;
    }

    public String getIsContainImg() {
        return isContainImg;
    }

    public void setIsContainImg(String isContainImg) {
        this.isContainImg = isContainImg;
    }

}
