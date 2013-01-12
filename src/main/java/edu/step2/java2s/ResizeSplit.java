package edu.step2.java2s;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class ResizeSplit {
  public static void main(String args[]) {
    String title = "Resize Split";

    final JFrame vFrame = new JFrame(title);
    vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton topButton = new JButton("Top");
    JButton bottomButton = new JButton("Bottom");
    final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPane.setTopComponent(topButton);
    splitPane.setBottomComponent(bottomButton);
    ActionListener oneActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        splitPane.setResizeWeight(1.0);
        vFrame.setSize(400, 250);
        vFrame.validate();
      }
    };
    bottomButton.addActionListener(oneActionListener);

    ActionListener anotherActionListener = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        splitPane.setResizeWeight(0.5);
        vFrame.setSize(300, 350);
        vFrame.validate();
      }
    };
    topButton.addActionListener(anotherActionListener);
    vFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
    vFrame.setSize(300, 150);
    vFrame.setVisible(true);

  }
}

    
