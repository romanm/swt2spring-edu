package edu.sw2ows3;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Framework2 extends WindowAdapter {
    public int numWindows = 0;
    private Point lastLocation = null;
    private int maxX = 500;
    private int maxY = 500;

    public Framework2() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxX = screenSize.width - 50;
        maxY = screenSize.height - 50;
        makeNewWindow();
    }
    public void makeNewWindow() {
    	numWindows++;
		JFrame frame = new JFrame("Caret Example "+numWindows);
        frame.addWindowListener(this);
		CaretSample2 sc2 = CaretSample2.newInstance(frame);
		frame.setSize(600, 400);
		addWindowMenuItems(sc2.getMainMenu(),this,frame);
		sc2.addMenu(frame);
		setLocation(frame);
		frame.setVisible(true);
    }
    public void makeNewWindow3() {
        JFrame frame = new MyFrame(this);
        numWindows++;
        System.out.println("Number of windows: " + numWindows);
        setLocation(frame);
        frame.setVisible(true);
    }

	private void setLocation(JFrame frame) {
		if (lastLocation != null) {
            //Move the window over and down 40 pixels.
            lastLocation.translate(40, 40);
            if ((lastLocation.x > maxX) || (lastLocation.y > maxY)) {
                lastLocation.setLocation(0, 0);
            }
            frame.setLocation(lastLocation);
        } else {
            lastLocation = frame.getLocation();
        }

        System.out.println("Frame location: " + lastLocation);
	}

    //This method must be evoked from the event-dispatching thread.
    public void quit(JFrame frame) {
        if (quitConfirmed(frame)) {
            System.out.println("Quitting.");
            System.exit(0);
        }
        System.out.println("Quit operation not confirmed; staying alive.");
    }

    private boolean quitConfirmed(JFrame frame) {
        String s1 = "Quit";
        String s2 = "Cancel";
        Object[] options = {s1, s2};
        int n = JOptionPane.showOptionDialog(frame,
                "Windows are still open.\nDo you really want to quit?",
                "Quit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                s1);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public void windowClosed(WindowEvent e) {
        numWindows--;
        System.out.println("Number of windows = " + numWindows);
        if (numWindows <= 0) {
            System.out.println("All windows gone.  Bye bye!");
            System.exit(0);
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        Framework2 framework = new Framework2();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    class MyFrame extends JFrame {
        protected Dimension defaultSize = new Dimension(200, 200);
        protected Framework2 framework = null;
		private JMenu menu;
        public JMenu getMenu() {return menu;}

		public MyFrame(Framework2 controller) {
            super("New Frame");
            framework = controller;
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addWindowListener(framework);
            
            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            menu = new JMenu("Window");
            menu.setMnemonic(KeyEvent.VK_W);
            addWindowMenuItems(menu,framework,this);
            menuBar.add(menu);
            setSize(defaultSize);
        }

    }
		private void addWindowMenuItems(JMenu menu, final Framework2 framework, final JFrame myFrame) {
			JMenuItem item = null;
            //close
            item = new JMenuItem("Close");
            item.setMnemonic(KeyEvent.VK_C);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Close window");
                    myFrame.setVisible(false);
                    myFrame.dispose();
                }
            });
            menu.add(item);

            //new
            item = new JMenuItem("New");
            item.setMnemonic(KeyEvent.VK_N);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("New window");
                    framework.makeNewWindow();
                }
            });
            menu.add(item);

            //quit
            item = new JMenuItem("Quit");
            item.setMnemonic(KeyEvent.VK_Q);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Quit request");
                    framework.quit(myFrame);
                }
            });
            menu.add(item);
    }
}
