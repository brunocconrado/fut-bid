package br.com.futbid.swing.ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class MainFrame extends JFrame implements IFrame {

    private static final Logger LOG = LoggerFactory.getLogger(MainFrame.class);

    private static final long serialVersionUID = 2014022802L;

    @Autowired
    private HeaderPanel header;

    @Autowired
    private DefaultPainel mainPanel;

    public MainFrame() {
    }

    @PostConstruct
    public void init() {
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
	    LOG.warn("An unexpected error", e);
	}

	add(header, "North");
	add(mainPanel, "Center");
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