//  Copyright © 2014-2023 PDF Technologies, Inc. All Rights Reserved.
//
//  THIS SOURCE CODE AND ANY ACCOMPANYING DOCUMENTATION ARE PROTECTED BY INTERNATIONAL COPYRIGHT LAW
//  AND MAY NOT BE RESOLD OR REDISTRIBUTED. USAGE IS BOUND TO THE ComPDFKit LICENSE AGREEMENT.
//  UNAUTHORIZED REPRODUCTION OR DISTRIBUTION IS SUBJECT TO CIVIL AND CRIMINAL PENALTIES.
//  This notice may not be removed from this file.

package cn.kdan.compdfkit.param;


public class COcrParameter extends CFileParameter {

    /**
     * language：Supported types and definitions.
     *
     * auto - automatic classification language.
     * english - English.
     * chinese - Simplified Chinese.
     * chinese_tra - Traditional Chinese.
     * korean - Korean.
     * japanese - Japanese.
     * latin - Latin.
     * devanagari - Sanskrit alphabet.
     */
    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
