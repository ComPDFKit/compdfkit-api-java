package com.compdfkit.param;

public abstract class CPDFOfficeCommonParameter extends CPDFFileParameter{
    public static final String IS_ALLOW_OCR = "1";
    public static final String NOT_ALLOW_OCR = "0";
    public static final String IS_CONTAIN_OCR_BG = "1";
    public static final String NOT_CONTAIN_OCR_BG = "0";
    public static final String IS_ONLY_AI_TABLE = "1";
    public static final String NOT_ONLY_AI_TABLE = "0";
    private String isAllowOcr;
    private String isContainOcrBg;
    private String isOnlyAiTable;

    public String getIsAllowOcr() {
        return isAllowOcr;
    }

    public void setIsAllowOcr(String isAllowOcr) {
        this.isAllowOcr = isAllowOcr;
    }

    public String getIsContainOcrBg() {
        return isContainOcrBg;
    }

    public void setIsContainOcrBg(String isContainOcrBg) {
        this.isContainOcrBg = isContainOcrBg;
    }

    public String getIsOnlyAiTable() {
        return isOnlyAiTable;
    }

    public void setIsOnlyAiTable(String isOnlyAiTable) {
        this.isOnlyAiTable = isOnlyAiTable;
    }
}
