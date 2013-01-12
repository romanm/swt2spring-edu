package edu.step2.java2s;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CaretSample2 {
	public static void main(String args[]) {
		CaretSample2 sc2 = new CaretSample2();
		sc2.make();
	}
	private void make() {
		JFrame frame = new JFrame("Caret Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 400));
		Container content = frame.getContentPane();

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

		final JTextField dot = new JTextField();
		final JTextField mark = new JTextField();

		infoPanel(infoPanel, dot, mark);

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		final JTextField taInfo = new JTextField();
		taInfo.setEditable(false);

		JPanel dialogPanel = new JPanel();
		dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
		Dimension minimumSize = new Dimension(100, 50);
		scrollPane.setMinimumSize(minimumSize);
		dialogPanel.add(taInfo);
		dialogPanel.add(new Label("l3"));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPane,dialogPanel);
		splitPane.setDividerLocation(250);

		//   content.add(dotPanel, BorderLayout.NORTH);
		//		content.add(scrollPane, BorderLayout.CENTER);
		content.add(splitPane, BorderLayout.CENTER);
		content.add(infoPanel, BorderLayout.SOUTH);

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
	private void infoPanel(JPanel infoPanel, final JTextField dot,final JTextField mark) {
		JToolBar toolBar = makeToolBar();
		infoPanel.add(toolBar);

		dot.setEditable(false);
		JLabel l1 = new JLabel("Dot: ");
		infoPanel.add(l1);
		infoPanel.add(dot);

		mark.setEditable(false);
		JLabel l2 = new JLabel("Mark: ");
		infoPanel.add(l2);
		infoPanel.add(mark);
	}
	private JToolBar makeToolBar() {
		JToolBar toolBar = new JToolBar();
		addActionButton(toolBar, "a1");
		addActionButton(toolBar, "a2");
		return toolBar;
	}
	private void addActionButton(JToolBar toolBar, String a1Str) {
		AbstractAction a1 = new AbstractAction(a1Str) {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(actionEvent.getSource());
			}
		};
		JButton a1Button = toolBar.add(a1);
		a1Button.setText(a1Str);
	}
}