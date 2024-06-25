//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFToJpgParameter extends CPDFFileParameter {

    /**
     * Value range 72-1500 (default 300)
     */
    private String imgDpi;

    public String getImgDpi() {
        return imgDpi;
    }

    public void setImgDpi(String imgDpi) {
        this.imgDpi = imgDpi;
    }
}
