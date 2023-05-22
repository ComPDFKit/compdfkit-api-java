//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;

import cn.kdan.compdfkit.enums.PDFServerEnum;
import cn.kdan.compdfkit.enums.PDFToOfficeEnum;

public class FileParameterFactory {

    public static <T extends FileParameter> T getFileParameterByType(PDFToOfficeEnum type) {
        Class<T> clazz;
        FileParameter fileParameter;
        switch (type) {
            case PDF_TO_EXCEL:
                clazz = (Class<T>) PDFToExcelParameter.class;
                fileParameter = new PDFToExcelParameter();
                break;
            case PDF_TO_HTML:
                clazz = (Class<T>) PDFToHtmlParameter.class;
                fileParameter = new PDFToHtmlParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(fileParameter);
    }

    public static <T extends FileParameter> T getFileParameterByType(PDFServerEnum type) {
        Class<T> clazz;
        FileParameter fileParameter;
        switch (type) {
            case INSERT:
                clazz = (Class<T>) PageInsertParameter.class;
                fileParameter = new PageInsertParameter();
                break;
            case SPLIT:
                clazz = (Class<T>) PageSplitParameter.class;
                fileParameter = new PageSplitParameter();
                break;
            case MERGE:
                clazz = (Class<T>) PageMergeParameter.class;
                fileParameter = new PageMergeParameter();
                break;
            case COMPRESS:
                clazz = (Class<T>) PDFCompressParameter.class;
                fileParameter = new PDFCompressParameter();
                break;
            case DELETE:
                clazz = (Class<T>) PageDeleteParameter.class;
                fileParameter = new PageDeleteParameter();
                break;
            case EXTRACT:
                clazz = (Class<T>) PageExtractParameter.class;
                fileParameter = new PageExtractParameter();
                break;
            case ROTATION:
                clazz = (Class<T>) PageRotationParameter.class;
                fileParameter = new PageRotationParameter();
                break;
            case ADD_WATERMARK:
                clazz = (Class<T>) AddWatermarkParameter.class;
                fileParameter = new AddWatermarkParameter();
                break;
            default:
                throw new IllegalArgumentException("Unsupported type:" + type);
        }
        return clazz.cast(fileParameter);
    }


}
