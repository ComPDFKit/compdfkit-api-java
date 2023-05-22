//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;

import lombok.Data;


@Data
public class AddWatermarkParameter extends FileParameter {

    /**
     * annotation type
     */
    private String type;

    /**
     * zoom
     */
    private String scale;

    /**
     * Transparency 0~1
     */
    private String opacity;

    /**
     * Rotation radians, a positive number means counterclockwise rotation
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
     * image path
     */
    private String imagepath;

    /**
     * text
     */
    private String content;

    /**
     * Text color, eg: #FFFFFF
     */
    private String textColor;

    /**
     * Is it at the front
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

}
