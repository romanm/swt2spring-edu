package edu.step2.dw.ui.button;

import java.awt.event.ActionEvent;


public class AddNewButtonActionListener extends ListTableActionListener {
    public void actionPerformed(ActionEvent e) {
        list.add("New Item");
        table.revalidate();
    }
}