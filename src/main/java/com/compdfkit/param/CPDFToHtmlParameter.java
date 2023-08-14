//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFToHtmlParameter extends CPDFFileParameter {

    public static final String IS_CONTAIN_ANNOT = "1";
    public static final String NOT_IS_CONTAIN_ANNOT = "0";
    public static final String IS_CONTAIN_IMG = "1";
    public static final String NOT_IS_CONTAIN_IMG = "0";

    public static final String SinglePage = "1";
    public static final String SinglePageNavigationByBookmarks = "2";
    public static final String MultiplePages = "3";
    public static final String MultiplePagesSplitByBookmarks = "4";

    /**
     * pageOptions 1:SinglePage、2:SinglePageNavigationByBookmarks、3:MultiplePages、4:MultiplePagesSplitByBookmarks
     */
    private String pageOptions;

    /**
     * Typesetting method (1: flow layout, 0: box layout) Default box layout
     */
    private String isContainAnnot;

    /**
     * Whether to include pictures (1: yes, 0: no)
     */
    private String isContainImg;

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

    public String getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(String pageOptions) {
        this.pageOptions = pageOptions;
    }
}
