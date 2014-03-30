package br.com.futbid.swing.main;


import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.futbid.service.impl.AuthenticationServiceImpl;
import br.com.futbid.swing.config.Config;
import br.com.futbid.swing.ui.IFrame;
import br.com.futbid.swing.ui.MainFrame;
import br.com.futbid.swing.ui.MainPanel;

public class FUT {
    
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    
    public static IFrame screen = new MainFrame();

    public static void main(String[] args) {
	try {
	    
	    Config.init();
	    screen = Config.getBean(MainFrame.class);

	    SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    screen.showScreen();
		    screen.showOnScreen(Config.getBean(MainPanel.class));
		}
	    });
	} catch (Exception e) {
	    LOG.error("An unexpected error occourred in the aplication. Please contact the admistrator", e);
	}
    }

   

}
