package edu.swows3;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.step2.dw.ItemTableModel;
import edu.step2.dw.ui.MainFrame;

public class ToDoDirect {
	public static void main(String[] args) {
		ToDoDirect df = new ToDoDirect();
		df.dd();
	}

	private void dd() {
		MainFrame mf = new MainFrame();
		mf.setTitle("direct build");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		JButton deleteButton = new JButton();
		deleteButton.setText("delete");
		buttonPanel.add(deleteButton);

		JTable itemTable = drugTable2();
		JScrollPane itemScrollPane = new JScrollPane(itemTable);

		mainPanel.add(buttonPanel);
		mainPanel.add(itemScrollPane);

		mf.setContentPane(mainPanel);
		mf.init();
	}
	private JTable drugTable2() {
		JTable itemTable = new JTable();
		ItemTableModel itemTableModel = new ItemTableModel();
		ArrayList arrayList = new ArrayList();
		arrayList.add("Item 1");
		arrayList.add("Item 2");
		arrayList.add("Item 3");
		itemTableModel.setItemList(arrayList);
		itemTable.setModel(itemTableModel);
		return itemTable;
	}
	private JTable drugTable() {
		JTable itemTable = new JTable();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addRow(newDrugInstance("drug1"));
		itemTable.setModel(defaultTableModel);
		return itemTable;
	}

	private Object[] newDrugInstance(String drugName) {
		return new Object[] {drugName};
	}
}
