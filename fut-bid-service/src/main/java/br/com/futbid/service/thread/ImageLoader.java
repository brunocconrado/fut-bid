package br.com.futbid.service.thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class ImageLoader extends Thread {
    
    private JPanel imageContainer;
    private URL url;

    public ImageLoader() {
    }

    public void run() {
	try {
	    
	    Image loadedImg = ImageIO.read(url);

	    ImageIcon normalizedimg = new ImageIcon(loadedImg.getScaledInstance(40, 40, 4));

	    JLabel clubPic = new JLabel(normalizedimg);
	    clubPic.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

	    imageContainer.setLayout(new BorderLayout());
	    imageContainer.add(clubPic, "Center");
	    imageContainer.updateUI();
	} catch (Exception e) {
	    e.printStackTrace();
	    //ApplicationLogUtil.addToLog(e.getMessage() + " : exception when try load player pictire!");
	}
    }

    public void setPanel(JPanel panel) {
	imageContainer = panel;
    }

    public void setUrl(URL url) {
	this.url = url;
    }
}
