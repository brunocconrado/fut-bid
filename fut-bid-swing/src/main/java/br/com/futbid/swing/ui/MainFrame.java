package br.com.futbid.swing.ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Header degrade
 */
public class MainFrame extends JFrame implements IFrame {

    private static final long serialVersionUID = 2014022801L;

    private JPanel mainPanel;

    private JPanel header;

    public MainFrame() {

	setTitle("FUT - BID");
	setSize(900, 700);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(3);
	setResizable(false);
	setLayout(new BorderLayout());

	try {
	    ImageIcon myPicture = new ImageIcon(getClass().getResource("/icon.png"));
	    setIconImage(myPicture.getImage());
	    /*
	     * if (isMac()) { Application application = Application.getApplication();
	     * application.setDockIconImage(myPicture.getImage()); }
	     */
	} catch (Exception e) {
	    //FIXME Add logback
	    System.out.println(e.getMessage());
	    //ApplicationLogUtil.addToLog(e.getMessage());
	}
	header = new HeaderPanel();
	add(this.header, "North");

	this.mainPanel = new DefaultPainel();
	add(this.mainPanel, "Center");
    }

    public void showScreen() {
	setVisible(true);
    }

    public void showOnScreen(Component component) {
	mainPanel.removeAll();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(component, "Center");
	mainPanel.updateUI();
    }

    @SuppressWarnings("unused")
    private static boolean isMac() {
	String OS = System.getProperty("os.name").toLowerCase();
	return OS.indexOf("mac") >= 0;
    }
}