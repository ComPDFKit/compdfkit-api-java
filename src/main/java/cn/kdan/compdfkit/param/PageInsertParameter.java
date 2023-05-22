//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;

import lombok.Data;


@Data
public class PageInsertParameter extends FileParameter {

    /**
     * page number
     */
    private String targetPage;

    /**
     * Page width (default 595)
     */
    private String width;

    /**
     * page height (842)
     */
    private String height;

    /**
     * Number of pages to insert (default 1)
     */
    private String number;

}
