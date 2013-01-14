package edu.sw2ows3;


import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class TabbedPaneDemo2 extends JPanel {
    public TabbedPaneDemo2() {
        super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        
        JComponent panel1 = makeTextPanel("medicament");
        tabbedPane.addTab("m",  panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel2 = makeTextPanel("dose");
        tabbedPane.addTab("d",  panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JComponent panel3 = makeTextPanel("app");
        tabbedPane.addTab("a", panel3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        JComponent panel4 = makeTextPanel("times");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("t", panel4);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add content to the window.
        frame.add(new TabbedPaneDemo2(), BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }
}
