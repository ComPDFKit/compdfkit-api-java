//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;

public class CPDFContentComparisonParameter extends CPDFFileParameter {

    /**
     * Specify whether to generate two output files during content comparison: 1 for yes, 0 for no (default value is 0).
     */
    private String isSaveTwo;

    /**
     * Specify whether to enable image comparison: 1 for yes, 0 for no (default value is 1).
     */
    private String imgCompare;

    /**
     * Specify whether to enable text comparison: 1 for yes, 0 for no (default value is 1).
     */
    private String textCompare;

    /**
     * Define the color for the replaced content (default value is #93B9FD).
     */
    private String replaceColor;

    /**
     * Define the color for the inserted content (default value is #C0FFEC).
     */
    private String insertColor;

    /**
     * Define the color for the deleted content (default value is #FBBDBF).
     */
    private String deleteColor;

    public String getIsSaveTwo() {
        return isSaveTwo;
    }

    public void setIsSaveTwo(boolean isSaveTwo) {
        this.isSaveTwo = isSaveTwo ? "1" : "0";
    }

    public String getImgCompare() {
        return imgCompare;
    }

    public void setImgCompare(boolean imgCompare) {
        this.imgCompare = imgCompare ? "1" : "0";
    }

    public String getTextCompare() {
        return textCompare;
    }

    public void setTextCompare(boolean textCompare) {
        this.textCompare = textCompare ? "1" : "0";
    }

    public String getReplaceColor() {
        return replaceColor;
    }

    public void setReplaceColor(String replaceColor) {
        this.replaceColor = replaceColor;
    }

    public String getInsertColor() {
        return insertColor;
    }

    public void setInsertColor(String insertColor) {
        this.insertColor = insertColor;
    }

    public String getDeleteColor() {
        return deleteColor;
    }

    public void setDeleteColor(String deleteColor) {
        this.deleteColor = deleteColor;
    }
}
