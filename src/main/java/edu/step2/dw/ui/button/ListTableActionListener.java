package edu.step2.dw.ui.button;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

public abstract class ListTableActionListener implements ActionListener {
	protected JTable table;
	protected List list;

	public void setList(List list) {
		this.list = list;
	}

	public void setTable(JTable itemTable) {
		this.table = itemTable;
	}
}