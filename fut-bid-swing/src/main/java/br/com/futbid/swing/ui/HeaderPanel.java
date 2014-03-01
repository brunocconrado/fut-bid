package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {
    
    private static final long serialVersionUID = 2014022801L;
    
    private static final int WIDTH = 100;
    
    private static final int HEIGHT = 75;

    protected void paintComponent(Graphics graphics) {
	super.paintComponent(graphics);
	Graphics2D g2d = (Graphics2D) graphics;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	GradientPaint gp = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, getHeight(), Color.gray);
	g2d.setPaint(gp);
	g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public HeaderPanel() {
	setLayout(new FlowLayout(FlowLayout.CENTER));
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
	try {
	    ImageIcon myPicture = new ImageIcon(getClass().getResource("/logo_small.png"));
	    JLabel picLabel = new JLabel(myPicture);
	    add(picLabel);
	} catch (Exception e) {
	    //FIXME Add logback
	    //ApplicationLogUtil.addToLog(e.getMessage());
	}
    }
}
