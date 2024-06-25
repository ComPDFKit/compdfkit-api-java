//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;

public class CPDFOverlayComparisonParameter extends CPDFFileParameter {
    /**
     * Adjust the transparency of the old comparing file. (Range: 0 to 1, default value: 0.5)
     */
    private String inTransparency;

    /**
     * Adjust the transparency of the new comparing file. (Range: 0 to 1, default value: 0.5)
     */
    private String newTransparency;

    /**
     * Set the blend mode (Default value is 0. 0 represents Normal).<p/>
     * 0: Normal,
     * 1: Multiply,
     * 2: Screen,
     * 3: Overlay,
     * 4: Darken,
     * 5: Lighten,
     * 6: ColorDodge,
     * 7: ColorBurn,
     * 8: HardLight,
     * 9: SoftLight,
     * 10: Difference,
     * 11: Exclusion,
     * 12: Hue,
     * 13: Saturation,
     * 14: Colour,
     * 15: Luminosity
     */
    private String coverType;

    /**
     * Set the color of the old comparing file. Default value: #FBBDBF)
     */
    private String inColor;

    /**
     * Set the color of the new comparing file. (Default value: #93B9FD)
     */
    private String newColor;

    public String getInTransparency() {
        return inTransparency;
    }

    public void setInTransparency(String inTransparency) {
        this.inTransparency = inTransparency;
    }

    public String getNewTransparency() {
        return newTransparency;
    }

    public void setNewTransparency(String newTransparency) {
        this.newTransparency = newTransparency;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getInColor() {
        return inColor;
    }

    public void setInColor(String inColor) {
        this.inColor = inColor;
    }

    public String getNewColor() {
        return newColor;
    }

    public void setNewColor(String newColor) {
        this.newColor = newColor;
    }
}
