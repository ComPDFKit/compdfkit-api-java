//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;

import cn.kdan.compdfkit.enums.CPDFServerEnum;
import cn.kdan.compdfkit.enums.CPDFToOfficeEnum;

public class CFileParameterFactory {

    public static <T extends CFileParameter> T getFileParameterByType(CPDFToOfficeEnum type) {
        Class<T> clazz;
        CFileParameter CFileParameter;
        switch (type) {
            case PDF_TO_EXCEL:
                clazz = (Class<T>) CPDFToExcelParameter.class;
                CFileParameter = new CPDFToExcelParameter();
                break;
            case PDF_TO_HTML:
                clazz = (Class<T>) CPDFToHtmlParameter.class;
                CFileParameter = new CPDFToHtmlParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(CFileParameter);
    }

    public static <T extends CFileParameter> T getFileParameterByType(CPDFServerEnum type) {
        Class<T> clazz;
        CFileParameter CFileParameter;
        switch (type) {
            case INSERT:
                clazz = (Class<T>) CPageInsertParameter.class;
                CFileParameter = new CPageInsertParameter();
                break;
            case SPLIT:
                clazz = (Class<T>) CPageSplitParameter.class;
                CFileParameter = new CPageSplitParameter();
                break;
            case MERGE:
                clazz = (Class<T>) CPageMergeParameter.class;
                CFileParameter = new CPageMergeParameter();
                break;
            case COMPRESS:
                clazz = (Class<T>) CPDFCompressParameter.class;
                CFileParameter = new CPDFCompressParameter();
                break;
            case DELETE:
                clazz = (Class<T>) CPageDeleteParameter.class;
                CFileParameter = new CPageDeleteParameter();
                break;
            case EXTRACT:
                clazz = (Class<T>) CPageExtractParameter.class;
                CFileParameter = new CPageExtractParameter();
                break;
            case ROTATION:
                clazz = (Class<T>) CPageRotationParameter.class;
                CFileParameter = new CPageRotationParameter();
                break;
            case ADD_WATERMARK:
                clazz = (Class<T>) CAddWatermarkParameter.class;
                CFileParameter = new CAddWatermarkParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(CFileParameter);
    }


}
