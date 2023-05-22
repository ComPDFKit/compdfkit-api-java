//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;

import lombok.Data;


@Data
public class PDFToExcelParameter extends FileParameter {

    /**
     * extractContentOptions（1:OnlyText、2:OnlyTable、3:AllContent）
     */
    private String contentOptions;

    /**
     * createWorksheetOptions（1:ForEachTable、2:ForEachPage、3:ForTheDocument）
     */
    private String worksheetOptions;

}
