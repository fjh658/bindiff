/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.Set;

final class GraphHelpers$11
implements INodeCallback {
    final /* synthetic */ Set val$nodes;

    GraphHelpers$11(Set set) {
        this.val$nodes = set;
    }

    public IterationMode next(ISelectableNode iSelectableNode) {
        this.val$nodes.add(iSelectableNode);
        return IterationMode.CONTINUE;
    }
}

