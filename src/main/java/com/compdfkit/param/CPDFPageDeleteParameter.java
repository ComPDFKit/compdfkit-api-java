//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


import java.util.List;


public class CPDFPageDeleteParameter extends CPDFFileParameter {

    /**
     * Delete the page range of the document, and the page number starts from 1.
     * For example: 1,2,5-10 (required, the page number entered must be greater than 0 and cannot exceed the maximum page number of the document)
     */
    private List<String> pageOptions;

    public List<String> getPageOptions() {
        return pageOptions;
    }

    public void setPageOptions(List<String> pageOptions) {
        this.pageOptions = pageOptions;
    }
}
