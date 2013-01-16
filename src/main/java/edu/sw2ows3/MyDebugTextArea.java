package edu.sw2ows3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyDebugTextArea extends JTextArea
	implements ActionListener, ItemListener {

	private class PopupMenuMouseListener extends MouseAdapter{
        JPopupMenu popup;
		public PopupMenuMouseListener(JPopupMenu popup) {
            this.popup = popup;
		}
		 public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }

	}
	public MyDebugTextArea(int i, int j) {
		super(i, j);
	}
	public MyDebugTextArea() {
		super();
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		JMenuItem source = (JMenuItem)(e.getSource());
		String s = "Action event detected.\n"
				+ "    Event source: " + source.getText()
				+ " (an instance of " + "getClassName(source)" + ")";
		//    + " (an instance of " + getClassName(source) + ")";
		append(s + "\n");
		setCaretPosition(getDocument().getLength());

	}
	public void itemStateChanged(ItemEvent e) {
		System.out.println("itemStateChanged");
		JMenuItem source = (JMenuItem)(e.getSource());
		String s = "Item event detected. \n"
				+ "    Event source: " + source.getText()
				+ " (an instance of " + "getClassName(source)" + ")\n"
				//               + " (an instance of " + getClassName(source) + ")\n"
				+ "    New state: "
				+ ((e.getStateChange() == ItemEvent.SELECTED) ?
						"selected":"unselected");
		append(s + "\n");
		setCaretPosition(getDocument().getLength());
	}
	 public void createPopupMenu() {
	        JMenuItem menuItem;
	 
	        //Create the popup menu.
	        JPopupMenu popup = new JPopupMenu();
	        menuItem = new JMenuItem("A popup menu item");
	        menuItem.addActionListener(this);
	        popup.add(menuItem);
	        menuItem = new JMenuItem("Another popup menu item");
	        menuItem.addActionListener(this);
	        popup.add(menuItem);
	 
	        //Add listener to the text area so the popup menu can come up.
	        MouseListener popupListener = new PopupMenuMouseListener(popup);
	        addMouseListener(popupListener);
	    }

	public static void main(String[] args) {
        JFrame frame = new JFrame("PopupMenuDemo");
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        MyDebugTextArea output = new MyDebugTextArea(5,30);
        output.createPopupMenu();
        JScrollPane scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(contentPane);
        frame.setSize(450, 260);
        frame.setVisible(true);
	}
}
