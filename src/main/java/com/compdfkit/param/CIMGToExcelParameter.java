//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CIMGToExcelParameter extends CPDFOfficeCommonParameter {

    /**
     * extractContentOptions（1:OnlyText、2:OnlyTable、3:AllContent）
     */
    private String contentOptions;

    /**
     * createWorksheetOptions（1:ForEachTable、2:ForEachPage、3:ForTheDocument）
     */
    private String worksheetOptions;

    public String getContentOptions() {
        return contentOptions;
    }

    public void setContentOptions(String contentOptions) {
        this.contentOptions = contentOptions;
    }

    public String getWorksheetOptions() {
        return worksheetOptions;
    }

    public void setWorksheetOptions(String worksheetOptions) {
        this.worksheetOptions = worksheetOptions;
    }
}
