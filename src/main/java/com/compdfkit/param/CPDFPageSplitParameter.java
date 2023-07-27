//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


import java.util.List;


public class CPDFPageSplitParameter extends CPDFFileParameter {

    /**
     * Page number collection, page number starts from 1, for example: 2-4 1,2,3 1-3,5 (this example is divided into 3 files, separated by spaces)
     */
    private List<String> pageOptions;

    public List<String> getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(List<String> pageOptions) {
        this.pageOptions = pageOptions;
    }
}
