//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;


public class CPDFToExcelParameter extends CFileParameter {

    public static final String IS_CONTAIN_ANNOT = "1";
    public static final String NOT_IS_CONTAIN_ANNOT = "0";
    public static final String IS_CONTAIN_IMG = "1";
    public static final String NOT_IS_CONTAIN_IMG = "0";

    /**
     * extractContentOptions（1:OnlyText、2:OnlyTable、3:AllContent）
     */
    private String contentOptions;

    /**
     * createWorksheetOptions（1:ForEachTable、2:ForEachPage、3:ForTheDocument）
     */
    private String worksheetOptions;

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
