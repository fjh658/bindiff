/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.graph.searchers.NodeSearcher;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TextCriterium
extends ConditionCriterium {
    private static final ImageIcon TEXT_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/text-condition.png");
    private final TextCriteriumPanel panel;

    public TextCriterium() {
        this.panel = new TextCriteriumPanel(this);
    }

    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Text '%s'", this.panel.getText());
    }

    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }

    @Override
    public Icon getIcon() {
        return TEXT_CONDITION_ICON;
    }

    @Override
    public boolean matches(ZyGraphNode zyGraphNode) {
        if (NodeSearcher.search(zyGraphNode, this.panel.getText(), this.panel.isRegularExpression(), this.panel.isCaseSensitive()).size() == 0) return false;
        return true;
    }

    public void update() {
        this.notifyListeners();
    }
}

