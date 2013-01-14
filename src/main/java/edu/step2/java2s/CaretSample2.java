package edu.step2.java2s;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CaretSample2 {
	private JTextArea textDebugArea;
	private JTable regimeTasksTable;
	JTextField dot, mark ;
	private JMenu mainMenu;
	private JToolBar toolBar;
	
	public JToolBar getToolBar() {
		return toolBar;
	}
	public JMenu getMainMenu() {
		return mainMenu;
	}
	public CaretSample2(JFrame frame) {
		mainMenu = new JMenu("File");
		mainMenu.setMnemonic(KeyEvent.VK_F);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container content = frame.getContentPane();
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		dot = new JTextField();
		mark = new JTextField();
		toolBar= new JToolBar();
		infoPanel(infoPanel, toolBar);
		JSplitPane splitPane = workPanel();
		content.add(splitPane, BorderLayout.CENTER);
		content.add(infoPanel, BorderLayout.SOUTH);
		
		CaretListener listener = new CaretListener() {
			public void caretUpdate(CaretEvent caretEvent) {
				dot.setText("" + caretEvent.getDot());
				mark.setText("" + caretEvent.getMark());
			}
		};
		
		textDebugArea.addCaretListener(listener);
	}
	void addMenu(JFrame frame) {
		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
		mb.add(mainMenu);
	}
	private JSplitPane workPanel() {
		JPanel sidebarPanel = sidebarPanel2();
		textDebugArea = new JTextArea();
//		sidebarPanel.add(new JScrollPane(textDebugArea));
		sidebarPanel.add(textDebugArea);
		JScrollPane contextPane = contextPane();
		contextPane.setBorder(BorderFactory.createTitledBorder( "Regime: FULFOX"));
		regimeTasksTable = new TableSample3().makeTable();
		regimeTasksTable.getSelectionModel().addListSelectionListener(new RowListener());
		regimeTasksTable.getColumnModel().getSelectionModel().addListSelectionListener(new ColumnListener());
		contextPane.setViewportView(regimeTasksTable);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, contextPane, sidebarPanel);
		splitPane.setDividerLocation(450);
		return splitPane;
	}
	
	private JPanel sidebarPanel2() {
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
		sidebarPanel.add(new Label("l3"));
		return sidebarPanel;
	}
	private JScrollPane contextPane() {
//		JScrollPane contextPane = new JScrollPane(textArea);
		JScrollPane contextPane = new JScrollPane();
		Dimension minimumSize = new Dimension(100, 50);
		contextPane.setMinimumSize(minimumSize);
		return contextPane;
	}
	private void infoPanel(JPanel infoPanel, JToolBar toolBar) {
		infoPanel.add(toolBar);
		dot.setEditable(false);
		infoPanel.add(new JLabel("Dot: "));
		infoPanel.add(dot);
		mark.setEditable(false);
		infoPanel.add(new JLabel("Mark: "));
		infoPanel.add(mark);
	}
	void addAction(JToolBar toolBar, JMenu mainMenu, String actionName) {
		AbstractAction actionSelf = new AbstractAction(actionName) {
			public void actionPerformed(ActionEvent actionEvent) {
				textDebugArea.append(actionEvent.getSource()+".\n");
			}
		};
		JButton actionButton = toolBar.add(actionSelf);
		actionButton.setText(actionName);
		mainMenu.add(actionSelf);
	}
	
	private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            textDebugArea.append("ROW SELECTION EVENT. \n");
            outputSelection();
        }
    }
	private class ColumnListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            textDebugArea.append("COLUMN SELECTION EVENT. \n");
            outputSelection();
        }
    }
	private void outputSelection() {
		textDebugArea.append(String.format("Lead: %d, %d. ",
				regimeTasksTable.getSelectionModel().getLeadSelectionIndex(),
				regimeTasksTable.getColumnModel().getSelectionModel().getLeadSelectionIndex()));
		textDebugArea.append("Rows:");
        for (int c : regimeTasksTable.getSelectedRows()) {
        	textDebugArea.append(String.format(" %d", c));
        }
        textDebugArea.append(". Columns:");
        for (int c : regimeTasksTable.getSelectedColumns()) {
        	textDebugArea.append(String.format(" %d", c));
        }
        textDebugArea.append(".\n");
    }
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Caret Example");
		CaretSample2 sc2 = new CaretSample2(frame);
		sc2.addAction(sc2.getToolBar(),sc2.getMainMenu(), "a1");
		sc2.addAction(sc2.getToolBar(),sc2.getMainMenu(), "a2");
		frame.setSize(600, 400);
		frame.setVisible(true);
		sc2.addMenu(frame);
	}
	private CaretSample2() {}
}
