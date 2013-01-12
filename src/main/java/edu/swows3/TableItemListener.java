package edu.swows3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class TableItemListener extends JFrame {
	public TableItemListener(){
		super("TableItemListener");
		JPanel contentPane = new JPanel();
    	contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(400, 150));
		JToolBar toolBar = makeToolBar();
		
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		
		contentPane.add(toolBar, BorderLayout.SOUTH);
		contentPane.add(splitPane, BorderLayout.CENTER);
		setContentPane(contentPane);
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
	public static void main(String[] args) {
		TableItemListener tableItemListener = new TableItemListener();
		tableItemListener.pack();
		tableItemListener.setVisible(true);
	}
}
