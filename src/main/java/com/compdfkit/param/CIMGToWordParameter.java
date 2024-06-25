//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CIMGToWordParameter extends CPDFOfficeCommonParameter {

    public static final String FLOW_LAYOUT = "1";
    public static final String FLOW_LAYOUT_SUPPORT_TABLE = "2";
    public static final String FRAME_MODE = "3";

    private String wordLayoutMode;

    public String getWordLayoutMode() {
        return wordLayoutMode;
    }

    public void setWordLayoutMode(String wordLayoutMode) {
        this.wordLayoutMode = wordLayoutMode;
    }
}
