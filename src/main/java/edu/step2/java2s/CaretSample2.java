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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
		JMenuBar mb = new JMenuBar();
		JMenu mainMenu = new JMenu("Menu");
		mb.add(mainMenu);
		frame.setJMenuBar(mb);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = frame.getContentPane();

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));

		final JTextField dot = new JTextField();
		final JTextField mark = new JTextField();
		JToolBar toolBar1 = new JToolBar();
		addActionButton(toolBar1,mainMenu, "a1");
		addActionButton(toolBar1,mainMenu, "a2");
		JToolBar toolBar = toolBar1;
		infoPanel(infoPanel, dot, mark,toolBar);

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
		splitPane.setDividerLocation(450);

		content.add(splitPane, BorderLayout.CENTER);
		content.add(infoPanel, BorderLayout.SOUTH);

		CaretListener listener = new CaretListener() {
			public void caretUpdate(CaretEvent caretEvent) {
				dot.setText("" + caretEvent.getDot());
				mark.setText("" + caretEvent.getMark());
			}
		};

		textArea.addCaretListener(listener);

		frame.setSize(600, 400);
		frame.setVisible(true);

	}
	private void infoPanel(JPanel infoPanel, final JTextField dot,final JTextField mark, JToolBar toolBar) {
		infoPanel.add(toolBar);
		dot.setEditable(false);
		infoPanel.add(new JLabel("Dot: "));
		infoPanel.add(dot);
		mark.setEditable(false);
		infoPanel.add(new JLabel("Mark: "));
		infoPanel.add(mark);
	}
	
	private void addActionButton(JToolBar toolBar, JMenu mainMenu, String a1Str) {
		AbstractAction action = new AbstractAction(a1Str) {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(actionEvent.getSource());
			}
		};
		JButton a1Button = toolBar.add(action);
		a1Button.setText(a1Str);
		mainMenu.add(action);
	}
}
