/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$Encoding implements SQLiteConfig$PragmaValue
{
    UTF8("UTF-8"),
    UTF16("UTF-16"),
    UTF16_LITTLE_ENDIAN("UTF-16le"),
    UTF16_BIG_ENDIAN("UTF-16be");
    
    public final String typeName;

    private SQLiteConfig$Encoding(String string2) {
        this.typeName = string2;
    }

    @Override
    public String getValue() {
        return this.typeName;
    }
}

