/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Lists$Partition;
import java.util.List;
import java.util.RandomAccess;

class Lists$RandomAccessPartition
extends Lists$Partition
implements RandomAccess {
    Lists$RandomAccessPartition(List list, int n2) {
        super(list, n2);
    }
}

