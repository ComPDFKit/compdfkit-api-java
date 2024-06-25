//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFToCSVParameter extends CPDFFileParameter {

    public static final String IS_CSV_MERGE = "1";
    public static final String NOT_IS_CSV_MERGE = "0";

    /**
     * Whether to merge CSV (1: Yes, 0: No)
     */
    private String isCsvMerge;

    public String getIsCsvMerge() {
        return isCsvMerge;
    }

    public void setIsCsvMerge(String isCsvMerge) {
        this.isCsvMerge = isCsvMerge;
    }
}
