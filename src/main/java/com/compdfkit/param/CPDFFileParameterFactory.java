//  Copyright © 2014-2024 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package com.compdfkit.param;

import com.compdfkit.enums.CPDFConversionEnum;
import com.compdfkit.enums.CPDFDocumentEditorEnum;

public class CPDFFileParameterFactory {

    public static <T extends CPDFFileParameter> T getFileParameterByType(CPDFConversionEnum type) {
        Class<T> clazz;
        CPDFFileParameter CPDFFileParameter;
        switch (type) {
            case PDF_TO_EXCEL:
                clazz = (Class<T>) CPDFToExcelParameter.class;
                CPDFFileParameter = new CPDFToExcelParameter();
                break;
            case PDF_TO_HTML:
                clazz = (Class<T>) CPDFToHtmlParameter.class;
                CPDFFileParameter = new CPDFToHtmlParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(CPDFFileParameter);
    }

    public static <T extends CPDFFileParameter> T getFileParameterByType(CPDFDocumentEditorEnum type) {
        Class<T> clazz;
        CPDFFileParameter CPDFFileParameter;
        switch (type) {
            case INSERT:
                clazz = (Class<T>) CPDFPageInsertParameter.class;
                CPDFFileParameter = new CPDFPageInsertParameter();
                break;
            case SPLIT:
                clazz = (Class<T>) CPDFPageSplitParameter.class;
                CPDFFileParameter = new CPDFPageSplitParameter();
                break;
            case MERGE:
                clazz = (Class<T>) CPDFPageMergeParameter.class;
                CPDFFileParameter = new CPDFPageMergeParameter();
                break;
            case COMPRESS:
                clazz = (Class<T>) CPDFCompressParameter.class;
                CPDFFileParameter = new CPDFCompressParameter();
                break;
            case DELETE:
                clazz = (Class<T>) CPDFPageDeleteParameter.class;
                CPDFFileParameter = new CPDFPageDeleteParameter();
                break;
            case EXTRACT:
                clazz = (Class<T>) CPDFPageExtractParameter.class;
                CPDFFileParameter = new CPDFPageExtractParameter();
                break;
            case ROTATION:
                clazz = (Class<T>) CPDFPageRotationParameter.class;
                CPDFFileParameter = new CPDFPageRotationParameter();
                break;
            case ADD_WATERMARK:
                clazz = (Class<T>) CPDFAddWatermarkParameter.class;
                CPDFFileParameter = new CPDFAddWatermarkParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(CPDFFileParameter);
    }


}
