//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

import lombok.Data;

import java.util.List;

@Data
public class QueryTaskRecordsResult {
    private int total;
    private int current;
    private int pages;
    private int size;
    private boolean optimizeCountSql;
    private List<RecordsItem> records;
    private Object maxLimit;
    private boolean searchCount;
    private List<Object> orders;
    private Object countId;
}
