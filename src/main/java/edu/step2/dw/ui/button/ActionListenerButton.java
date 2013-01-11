package edu.step2.dw.ui.button;

import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ActionListenerButton extends JButton {
    private ActionListener actionListener;

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void init() {
        this.addActionListener(actionListener);
    }
}