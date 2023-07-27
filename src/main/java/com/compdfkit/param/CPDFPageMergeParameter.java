//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;

import java.util.List;


public class CPDFPageMergeParameter extends CPDFFileParameter {
    /**
     * Merge the page range of the document, the page number starts from 1.
     * For example: 1,2,4,6,9-11 (if you do not enter all pages by default, the page number entered cannot exceed the maximum page number of the
     */
    private List<String> pageOptions;

    public List<String> getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(List<String> pageOptions) {
        this.pageOptions = pageOptions;
    }
}
