/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.g.e;

final class cN
implements Comparator {
    final byte[] a;

    cN(byte[] arrby) {
        this.a = arrby;
    }

    public int compare(Object object, Object object2) {
        byte by2 = this.a[((d)object).b()];
        byte by3 = this.a[((d)object2).b()];
        if (by2 == -2) {
            if (by3 != -2) return 1;
            return 0;
        }
        if (by3 != -2) return e.a(by2, by3);
        return -1;
    }
}

