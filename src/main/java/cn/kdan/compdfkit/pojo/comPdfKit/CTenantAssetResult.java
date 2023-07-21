//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

import java.util.List;

public class CTenantAssetResult {
    private List<CTenantAssetItem> tenantAsset;

    public List<CTenantAssetItem> getTenantAsset() {
        return tenantAsset;
    }

    public void setTenantAsset(List<CTenantAssetItem> tenantAsset) {
        this.tenantAsset = tenantAsset;
    }

    @Override
    public String toString() {
        return "QueryTenantAssetResult{" +
                "tenantAsset=" + tenantAsset +
                '}';
    }
}
