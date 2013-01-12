package edu.step2.java2s;



import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.KeyStroke;

public class CreatingAnAction {
	public static void main(String[] argv) throws Exception {
    final Action action = new AbstractAction("Action Name") {
      {
        putValue(Action.SHORT_DESCRIPTION, "Tool Tip Text");

        putValue(Action.LONG_DESCRIPTION, "Help Text");

        Icon icon = new ImageIcon("icon.gif");
        putValue(Action.SMALL_ICON, icon);

        putValue(Action.MNEMONIC_KEY, new Integer(java.awt.event.KeyEvent.VK_A));
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control F2"));
      }
      public void actionPerformed(ActionEvent evt) {
        System.out.println("action");
      }
    };

    JButton button = new JButton(action);
  }
}

   