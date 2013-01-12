package edu.step2.java2s;


import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class TableSample2 {
	public static void main(String args[]) {
		Object rows[][] = { 
				{ "one", "ichi - \u4E00", "un" },
				{ "two", "ni - \u4E8C", "deux" },
				{ "three", "san - \u4E09", "trois" },
				{ "four", "shi - 四", "quatre" },
				{ "five", "go - \u4E94", "cinq" },
				{ "six", "roku - \u516D", "treiza" },
				{ "seven", "shichi - \u4E03", "sept" },
				{ "eight", "hachi - \u516B", "huit" },
				{ "nine", "kyu - \u4E5D", "neuf" },
				{ "ten", "ju - \u5341", "dix" }
		};
		Object options[] = { "un", "deux", "trois", "quatre", "cinq", "treiza",
				"sept", "huit", "neuf", "dix" };
		JComboBox comboBox = new JComboBox(options);
		comboBox.setMaximumRowCount(4);
		TableCellEditor editor = new DefaultCellEditor(comboBox);

		Object headers[] = { "English", "Japanese", "French" };
		JFrame frame = new JFrame("JTable Anatomy");
		class CustomTableModel extends DefaultTableModel {
			public CustomTableModel(Object rowData[][], Object columnNames[]) {
				super(rowData, columnNames);
			}

			public Class getColumnClass(int col) {
				Vector v = (Vector) dataVector.elementAt(0);
				return v.elementAt(col).getClass();
			}

			public boolean isCellEditable(int row, int col) {
				return true;
			}
		}
		JTable table = new JTable(new DefaultTableModel(rows, headers));

		//    ColumnModelUtilities.removeHeaders(table.getColumnModel());
		table.getColumnModel().getColumn(2).setCellEditor(editor);

		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}
}