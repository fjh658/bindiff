/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$ObjectPredicate;
import javax.annotation.Nullable;

final class Predicates$ObjectPredicate$3
extends Predicates$ObjectPredicate {
    Predicates$ObjectPredicate$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public boolean apply(@Nullable Object object) {
        if (object != null) return false;
        return true;
    }

    public String toString() {
        return "Predicates.isNull()";
    }
}

