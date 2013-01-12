package edu.step2.java2s;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class SwingSplitSample1 {
	public static void main(String args[]) {
		SwingSplitSample1 sss = new SwingSplitSample1();
		sss.build();
	}

	private void build() {
		JFrame frame = new JFrame("JSplitPane Sample");
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		init(frame);
	}

	private void init(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
