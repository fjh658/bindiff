/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class JHexView$DownAction
extends AbstractAction {
    private static final long serialVersionUID = -6501310447863685486L;
    final /* synthetic */ JHexView this$0;

    private JHexView$DownAction(JHexView jHexView) {
        this.this$0 = jHexView;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JHexView.access$1000(this.this$0, actionEvent, 2 * JHexView.access$900(this.this$0));
    }

    /* synthetic */ JHexView$DownAction(JHexView jHexView, JHexView$1 jHexView$1) {
        this(jHexView);
    }
}

