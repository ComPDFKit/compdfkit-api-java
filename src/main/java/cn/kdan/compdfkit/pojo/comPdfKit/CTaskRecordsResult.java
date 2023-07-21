//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.pojo.comPdfKit;

import java.util.List;

public class CTaskRecordsResult {
    private int total;
    private int current;
    private int pages;
    private int size;
    private boolean optimizeCountSql;
    private List<CRecordsItem> records;
    private Object maxLimit;
    private boolean searchCount;
    private List<Object> orders;
    private Object countId;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOptimizeCountSql() {
        return optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    public List<CRecordsItem> getRecords() {
        return records;
    }

    public void setRecords(List<CRecordsItem> records) {
        this.records = records;
    }

    public Object getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Object maxLimit) {
        this.maxLimit = maxLimit;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public List<Object> getOrders() {
        return orders;
    }

    public void setOrders(List<Object> orders) {
        this.orders = orders;
    }

    public Object getCountId() {
        return countId;
    }

    public void setCountId(Object countId) {
        this.countId = countId;
    }

    @Override
    public String toString() {
        return "QueryTaskRecordsResult{" +
                "total=" + total +
                ", current=" + current +
                ", pages=" + pages +
                ", size=" + size +
                ", optimizeCountSql=" + optimizeCountSql +
                ", records=" + records +
                ", maxLimit=" + maxLimit +
                ", searchCount=" + searchCount +
                ", orders=" + orders +
                ", countId=" + countId +
                '}';
    }
}
