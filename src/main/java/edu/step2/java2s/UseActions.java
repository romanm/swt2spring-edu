package edu.step2.java2s;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

public class UseActions {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Use TextAction");
    Container contentPane = frame.getContentPane();
    Dimension empty = new Dimension(0, 0);

    final JTextArea leftArea = new JTextArea();
    JScrollPane leftScrollPane = new JScrollPane(leftArea);
    leftScrollPane.setPreferredSize(empty);

    final JTextArea rightArea = new JTextArea();
    JScrollPane rightScrollPane = new JScrollPane(rightArea);
    rightScrollPane.setPreferredSize(empty);

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu menu = new JMenu("Options");
    menuBar.add(menu);
    JMenuItem menuItem;

    Action readAction = leftArea.getActionMap().get(DefaultEditorKit.readOnlyAction);
    menuItem = menu.add(readAction);
    menuItem.setText("Make read-only");
    Action writeAction = leftArea.getActionMap().get(DefaultEditorKit.writableAction);
    menuItem = menu.add(writeAction);
    menuItem.setText("Make writable");

    menu.addSeparator();

    Action cutAction = leftArea.getActionMap().get(DefaultEditorKit.cutAction);
    menuItem = menu.add(cutAction);
    menuItem.setText("Cut");
    Action copyAction = leftArea.getActionMap().get(DefaultEditorKit.copyAction);
    menuItem = menu.add(copyAction);
    menuItem.setText("Copy");
    Action pasteAction = leftArea.getActionMap().get(DefaultEditorKit.pasteAction);
    menuItem = menu.add(pasteAction);
    menuItem.setText("Paste");

    contentPane.add(splitPane, BorderLayout.CENTER);
    frame.setSize(400, 250);
    frame.setVisible(true);
    splitPane.setDividerLocation(.5);
  }
}
