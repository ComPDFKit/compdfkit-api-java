//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

public class CToolResultItem {
    private String sourceTypeName;
    private String executeTypeUrl;
    private String targetTypeName;

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }

    public String getExecuteTypeUrl() {
        return executeTypeUrl;
    }

    public void setExecuteTypeUrl(String executeTypeUrl) {
        this.executeTypeUrl = executeTypeUrl;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    @Override
    public String toString() {
        return "QueryToolResultItem{" +
                "sourceTypeName='" + sourceTypeName + '\'' +
                ", executeTypeUrl='" + executeTypeUrl + '\'' +
                ", targetTypeName='" + targetTypeName + '\'' +
                '}';
    }
}
