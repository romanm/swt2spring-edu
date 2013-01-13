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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CaretSample2 {
	private void make(JFrame frame) {
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
		addAction(toolBar1,mainMenu, "a1");
		addAction(toolBar1,mainMenu, "a2");
		JToolBar toolBar = toolBar1;
		infoPanel(infoPanel, dot, mark,toolBar);
		CaretListener listener = new CaretListener() {
			public void caretUpdate(CaretEvent caretEvent) {
				dot.setText("" + caretEvent.getDot());
				mark.setText("" + caretEvent.getMark());
			}
		};

		JSplitPane splitPane = workPanel2(listener);

		content.add(splitPane, BorderLayout.CENTER);
		content.add(infoPanel, BorderLayout.SOUTH);
	}
	private JSplitPane workPanel2(CaretListener listener) {
		JPanel sidebarPanel = sidebarPanel2();
		JTextArea textArea = getTextArea(listener);
		sidebarPanel.add(textArea);
		JScrollPane contextPane = contextPanel2();
		TableSample3 tableSample3 = new TableSample3();
		JTable makeTable = tableSample3.makeTable();
		contextPane.setViewportView(makeTable);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,contextPane,sidebarPanel);
		splitPane.setDividerLocation(450);
		return splitPane;
	}
	private JSplitPane workPanel(CaretListener listener) {
		JTextArea textArea = getTextArea(listener);
		
		JPanel sidebarPanel = sidebarPanel();
		JScrollPane contextPane = contextPanel(textArea);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,contextPane,sidebarPanel);
		splitPane.setDividerLocation(450);
		return splitPane;
	}
	private JPanel sidebarPanel2() {
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
		sidebarPanel.add(new Label("l3"));
		return sidebarPanel;
	}
	private JPanel sidebarPanel() {
		final JTextField taInfo = new JTextField();
		taInfo.setEditable(false);
		JPanel sidebarPanel = sidebarPanel2();
		sidebarPanel.add(taInfo);
		return sidebarPanel;
	}
	private JScrollPane contextPanel(JTextArea textArea) {
//		JScrollPane contextPane = new JScrollPane(textArea);
		JScrollPane contextPane = contextPanel2();
		contextPane.setViewportView(textArea);
		return contextPane;
	}
	private JScrollPane contextPanel2() {
		JScrollPane contextPane = new JScrollPane();
		Dimension minimumSize = new Dimension(100, 50);
		contextPane.setMinimumSize(minimumSize);
		return contextPane;
	}
	private JTextArea getTextArea(CaretListener listener) {
		JTextArea textArea = new JTextArea();
		textArea.addCaretListener(listener);
		return textArea;
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
	private void addAction(JToolBar toolBar, JMenu mainMenu, String a1Str) {
		AbstractAction action = new AbstractAction(a1Str) {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(actionEvent.getSource());
			}
		};
		JButton a1Button = toolBar.add(action);
		a1Button.setText(a1Str);
		mainMenu.add(action);
	}
	public static void main(String args[]) {
		JFrame frame = new JFrame("Caret Example");
		CaretSample2 sc2 = new CaretSample2();
		sc2.make(frame);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
