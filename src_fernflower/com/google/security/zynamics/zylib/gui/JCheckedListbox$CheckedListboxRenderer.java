package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.JCheckedListbox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

class JCheckedListbox$CheckedListboxRenderer extends JPanel implements ListCellRenderer {
   private static final long serialVersionUID = 7446207257969469739L;
   private final JCheckBox checkBox;
   private final LineBorder SELECTED_BORDER;
   private final LineBorder UNSELECTED_BORDER;
   private final Color SELECTED_COLOR;
   private final Color UNSELECTED_COLOR;
   // $FF: synthetic field
   final JCheckedListbox this$0;

   public JCheckedListbox$CheckedListboxRenderer(JCheckedListbox var1) {
      super(new BorderLayout());
      this.this$0 = var1;
      this.checkBox = new JCheckBox();
      this.SELECTED_BORDER = new LineBorder(Color.DARK_GRAY);
      this.UNSELECTED_BORDER = new LineBorder(Color.WHITE);
      this.SELECTED_COLOR = new Color(12439527);
      this.UNSELECTED_COLOR = Color.WHITE;
      this.setBorder(this.UNSELECTED_BORDER);
      this.setBackground(this.UNSELECTED_COLOR);
      this.checkBox.setBackground(this.UNSELECTED_COLOR);
   }

   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      this.checkBox.setEnabled(this.this$0.isEnabled());
      if(JCheckedListbox.access$100(this.this$0)) {
         this.setBorder(var4?this.SELECTED_BORDER:this.UNSELECTED_BORDER);
         this.setBackground(var4?this.SELECTED_COLOR:this.UNSELECTED_COLOR);
         this.checkBox.setBackground(var4?this.SELECTED_COLOR:this.UNSELECTED_COLOR);
      }

      this.checkBox.setText(var2.toString());
      this.checkBox.setSelected(JCheckedListbox.access$200(this.this$0)[var3]);
      this.checkBox.updateUI();
      this.add(this.checkBox, "West");
      return this;
   }
}
