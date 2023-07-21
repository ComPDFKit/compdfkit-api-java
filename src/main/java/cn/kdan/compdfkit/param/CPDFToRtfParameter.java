//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;


public class CPDFToRtfParameter extends CFileParameter {

    public static final String IS_CONTAIN_ANNOT = "1";
    public static final String NOT_IS_CONTAIN_ANNOT = "0";
    public static final String IS_CONTAIN_IMG = "1";
    public static final String NOT_IS_CONTAIN_IMG = "0";


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

}
