/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

class V
implements Iterator {
    V() {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

