/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.e.a.Y;

class L
implements Y {
    L() {
    }

    @Override
    public double a(double d2) {
        if (!this.b(d2)) return Math.sqrt(d2);
        return 0.0;
    }

    @Override
    public boolean b(double d2) {
        if (d2 > 0.0) return false;
        return true;
    }
}

