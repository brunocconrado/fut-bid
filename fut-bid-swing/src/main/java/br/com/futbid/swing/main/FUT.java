package br.com.futbid.swing.main;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

import javax.swing.SwingUtilities;

import br.com.futbid.swing.ui.IFrame;
import br.com.futbid.swing.ui.MainFrame;
import br.com.futbid.swing.ui.MainPanel;

public class FUT {
    
    public static final IFrame screen = new MainFrame();

    public static void main(String[] args) {
	try {
	    setSystemProperties();

	    SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    screen.showScreen();
		    screen.showOnScreen(new MainPanel());
		}
	    });
	} catch (Exception e) {
	    //FIXME Add logback
	    //ApplicationLogUtil.addToLog(e.getMessage());
	}
    }

    private static void setSystemProperties() {
	try {
	    System.setProperty("file.encoding", "UTF-8");
	    Field charset = Charset.class.getDeclaredField("defaultCharset");
	    charset.setAccessible(true);
	    charset.set(null, null);
	} catch (Exception e) {
	    throw new RuntimeException("Can't set default charset");
	}
    }

}
