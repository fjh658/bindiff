/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$StrongEntry;
import javax.annotation.Nullable;

final class LocalCache$StrongAccessEntry
extends LocalCache$StrongEntry {
    volatile long accessTime = Long.MAX_VALUE;
    LocalCache$ReferenceEntry nextAccess = LocalCache.nullEntry();
    LocalCache$ReferenceEntry previousAccess = LocalCache.nullEntry();

    LocalCache$StrongAccessEntry(Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(object, n2, localCache$ReferenceEntry);
    }

    @Override
    public long getAccessTime() {
        return this.accessTime;
    }

    @Override
    public void setAccessTime(long l2) {
        this.accessTime = l2;
    }

    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }

    @Override
    public void setNextInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.nextAccess = localCache$ReferenceEntry;
    }

    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }

    @Override
    public void setPreviousInAccessQueue(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.previousAccess = localCache$ReferenceEntry;
    }
}

