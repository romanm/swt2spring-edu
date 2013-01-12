package edu.step2.java2s;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class EnablingAnAction {
  public static void main(String[] argv) throws Exception {
    final Action action = new AbstractAction("Action Name") {
      public void actionPerformed(ActionEvent evt) {
        System.out.println("action");
      }
    };
   
    JFrame frame = new JFrame();
    JButton button = new JButton(action);

    JTextField textfield = new JTextField();
    textfield.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("F2"),
        action.getValue(Action.NAME));
    textfield.getActionMap().put(action.getValue(Action.NAME), action);
  }
}

   
    
    
  