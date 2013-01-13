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

public class TableSample3 {
	public static void main(String args[]) {
		TableSample3 tableSample2 = new TableSample3();
		JTable table = tableSample2.makeTable();
		//    ColumnModelUtilities.removeHeaders(table.getColumnModel());
		JScrollPane scrollPane = new JScrollPane(table);
		JFrame frame = new JFrame("JTable Anatomy");
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setSize(400, 150);
		frame.setVisible(true);
	}
	JTable makeTable() {
		Object[][] rows = getRows();
		Object[] headers = getHeaders();
		JTable table = new JTable(new DefaultTableModel(rows, headers));
		
		TableCellEditor editor = getFrenchEditor();
		table.getColumnModel().getColumn(2).setCellEditor(editor);
		
		return table;
	}
	private TableCellEditor getFrenchEditor() {
		Object options[] = { "un", "deux", "trois", "quatre", "cinq", "treiza",
				"sept", "huit", "neuf", "dix" };
		JComboBox comboBox = new JComboBox(options);
		comboBox.setMaximumRowCount(4);
		TableCellEditor editor = new DefaultCellEditor(comboBox);
		return editor;
	}
	private Object[] getHeaders() {
		Object headers[] = { "English", "Japanese", "French","Українська" };
		return headers;
	}
	private Object[][] getRows() {
		Object rows[][] = { 
				{ "one", "ichi - \u4E00", "un","один" },
				{ "two", "ni - \u4E8C", "deux","два" },
				{ "three", "san - \u4E09", "trois","три" },
				{ "four", "shi - 四", "quatre","чотири" },
				{ "five", "go - \u4E94", "cinq","п’ять" },
				{ "six", "roku - \u516D", "treiza","шість" },
				{ "seven", "shichi - \u4E03", "sept","сім" },
				{ "eight", "hachi - \u516B", "huit","вісім" },
				{ "nine", "kyu - \u4E5D", "neuf","девіть" },
				{ "ten", "ju - \u5341", "dix","десіть" }
		};
		return rows;
	}
}
