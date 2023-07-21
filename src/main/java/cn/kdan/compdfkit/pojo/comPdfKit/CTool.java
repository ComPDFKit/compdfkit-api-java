//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

public class CTool {
    private String sourceTypeName;
    private String targetTypeName;
    private String executeTypeUrl;

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    public String getExecuteTypeUrl() {
        return executeTypeUrl;
    }

    public void setExecuteTypeUrl(String executeTypeUrl) {
        this.executeTypeUrl = executeTypeUrl;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "sourceTypeName='" + sourceTypeName + '\'' +
                ", targetTypeName='" + targetTypeName + '\'' +
                ", executeTypeUrl='" + executeTypeUrl + '\'' +
                '}';
    }
}
