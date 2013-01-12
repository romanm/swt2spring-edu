package edu.step2.java2s;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CaretSample {
 public static void main(String args[]) {
   JFrame frame = new JFrame("Caret Example");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Container content = frame.getContentPane();
   JTextArea textArea = new JTextArea();
   JScrollPane scrollPane = new JScrollPane(textArea);
   content.add(scrollPane, BorderLayout.CENTER);

   final JTextField dot = new JTextField();
   dot.setEditable(false);
   JPanel dotPanel = new JPanel(new BorderLayout());
   dotPanel.add(new JLabel("Dot: "), BorderLayout.WEST);
   dotPanel.add(dot, BorderLayout.CENTER);
   content.add(dotPanel, BorderLayout.NORTH);

   final JTextField mark = new JTextField();
   mark.setEditable(false);
   JPanel markPanel = new JPanel(new BorderLayout());
   markPanel.add(new JLabel("Mark: "), BorderLayout.WEST);
   markPanel.add(mark, BorderLayout.CENTER);
   content.add(markPanel, BorderLayout.SOUTH);

   CaretListener listener = new CaretListener() {
     public void caretUpdate(CaretEvent caretEvent) {
       dot.setText("" + caretEvent.getDot());
       mark.setText("" + caretEvent.getMark());
     }
   };

   textArea.addCaretListener(listener);

   frame.setSize(250, 150);
   frame.setVisible(true);
 }
}