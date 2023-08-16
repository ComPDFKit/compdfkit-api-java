//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;


public class CPDFAddWatermarkParameter extends CPDFFileParameter {

    public static final String TYPE_TEXT = "text";
    public static final String TYPE_IMAGE = "image";

    public static final String VERTALIGN_TOP = "top";
    public static final String VERTALIGN_CENTER = "center";
    public static final String VERTALIGN_BOTTOM = "bottom";

    public static final String HORIZALIGN_LEFT = "left";
    public static final String HORIZALIGN_CENTER = "center";
    public static final String HORIZALIGN_RIGHT = "right";

    /**
     * Watermark type (text: text type watermark, image: image type watermark)
     */
    private String type;

    /**
     * zoom (image type attribute)
     */
    private String scale;

    /**
     * Transparency 0~1
     */
    private String opacity;

    /**
     * Rotation angle, a positive number means counterclockwise rotation
     */
    private String rotation;

    /**
     * Page number, page number from start, for example: 1,2,4,6
     */
    private String targetPages;

    /**
     * Vertical alignment: top, center, bottom
     */
    private String vertalign;

    /**
     * Horizontal alignment: left, center, right
     */
    private String horizalign;

    /**
     * horizontal offset
     */
    private String xoffset;

    /**
     * vertical offset
     */
    private String yoffset;

    /**
     * text
     */
    private String content;

    /**
     * Text color, eg: #FFFFFF
     */
    private String textColor;

    /**
     * Setting watermark layer <br/>
     * "0" false: No need to pin it to the top <br/>
     * "1" true: Pin it to the top <br/>
     * null  No need to pin it to the top
     */
    private String front;

    /**
     * Whether to fill the entire page
     */
    private String fullScreen;

    /**
     * horizontal spacing
     */
    private String horizontalSpace;

    /**
     * vertical spacing
     */
    private String verticalSpace;

    /**
     * Extended information, base 64 encoding
     */
    private String extension;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getTargetPages() {
        return targetPages;
    }

    public void setTargetPages(String targetPages) {
        this.targetPages = targetPages;
    }

    public String getVertalign() {
        return vertalign;
    }

    public void setVertalign(String vertalign) {
        this.vertalign = vertalign;
    }

    public String getHorizalign() {
        return horizalign;
    }

    public void setHorizalign(String horizalign) {
        this.horizalign = horizalign;
    }

    public String getXoffset() {
        return xoffset;
    }

    public void setXoffset(String xoffset) {
        this.xoffset = xoffset;
    }

    public String getYoffset() {
        return yoffset;
    }

    public void setYoffset(String yoffset) {
        this.yoffset = yoffset;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(String fullScreen) {
        this.fullScreen = fullScreen;
    }

    public String getHorizontalSpace() {
        return horizontalSpace;
    }

    public void setHorizontalSpace(String horizontalSpace) {
        this.horizontalSpace = horizontalSpace;
    }

    public String getVerticalSpace() {
        return verticalSpace;
    }

    public void setVerticalSpace(String verticalSpace) {
        this.verticalSpace = verticalSpace;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
