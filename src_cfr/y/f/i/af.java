/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.HashMap;
import y.f.i.ao;
import y.g.p;

class aF
extends p {
    private HashMap a = new HashMap();

    @Override
    public Object b(Object object) {
        return this.a.get(object);
    }

    public void a(ao ao2, Object object) {
        this.a.put(ao2, object);
    }
}

