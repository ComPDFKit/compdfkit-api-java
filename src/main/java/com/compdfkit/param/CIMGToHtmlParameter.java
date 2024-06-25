//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CIMGToHtmlParameter extends CPDFOfficeCommonParameter {
    public static final String SinglePage = "1";
    public static final String SinglePageNavigationByBookmarks = "2";
    public static final String MultiplePages = "3";
    public static final String MultiplePagesSplitByBookmarks = "4";

    /**
     * pageOptions 1:SinglePage、2:SinglePageNavigationByBookmarks、3:MultiplePages、4:MultiplePagesSplitByBookmarks
     */
    private String pageOptions;

    public String getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(String pageOptions) {
        this.pageOptions = pageOptions;
    }
}
