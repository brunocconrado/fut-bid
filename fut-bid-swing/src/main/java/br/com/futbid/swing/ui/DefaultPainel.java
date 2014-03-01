package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class DefaultPainel extends JPanel {
    
    private static final long serialVersionUID = 2014022801L;

    public void paintComponent(Graphics grphcs) {
	super.paintComponent(grphcs);
	
	Graphics2D g2d = (Graphics2D) grphcs;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	GradientPaint gp = new GradientPaint(0.0F, 0.0F, Color.gray, 0.0F, getHeight(), Color.white);
	g2d.setPaint(gp);
	g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
