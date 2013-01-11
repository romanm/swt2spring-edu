package edu.step2.dw;

import java.util.List;

import javax.swing.table.AbstractTableModel;


public class ItemTableModel extends AbstractTableModel {
    List itemList;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int column) {
        return "Items";
    }

    public void setItemList(List itemList) {
        this.itemList = itemList;
    }

    public int getRowCount() {
        return itemList.size();
    }

    public void setValueAt(Object value, 
                           int rowIndex, int columnIndex) {
        itemList.set(rowIndex, value);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return itemList.get(rowIndex);
    }
}