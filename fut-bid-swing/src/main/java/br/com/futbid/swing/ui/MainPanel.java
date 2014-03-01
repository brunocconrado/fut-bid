package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.futbid.swing.ui.enumeration.Tab;
import br.com.futbid.swing.ui.listener.ChangeTabListener;
import br.com.futbid.swing.ui.settings.SettingsPanel;
import br.com.futbid.swing.ui.settings.impl.SettingsPanelImpl;

public class MainPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    private SettingsPanel settingsPanel;
   /* private BasePanel ap = new BasePanel();
    private SettingsPanel sp = new SettingsPanel();
    private AutobuyerInventoryPanel buyIP = new AutobuyerInventoryPanel();
    private AutobidderInventoryPanel bidIP = new AutobidderInventoryPanel();*/

    public MainPanel() {
	
	setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

	final JTabbedPane tabPanel = new JTabbedPane();
	tabPanel.setPreferredSize(new Dimension(800, 550));

	settingsPanel = new SettingsPanelImpl();
	settingsPanel.setName(Tab.SETTINGS.getName());
	tabPanel.addTab(Tab.SETTINGS.getName(), (Component) settingsPanel);
	
	/*tabPanel.addTab("Autobuyer", this.ap);
	tabPanel.addTab("Settings", this.sp);
	tabPanel.addTab("Buyer inventory", this.buyIP);
	tabPanel.addTab("Bidder inventory", this.bidIP);*/

	add(tabPanel);

	tabPanel.addChangeListener(new ChangeTabListener(Tab.SETTINGS));
    }

    protected void paintComponent(Graphics grphcs) {
	super.paintComponent(grphcs);
	Graphics2D g2d = (Graphics2D) grphcs;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	GradientPaint gp = new GradientPaint(0.0F, 0.0F, Color.gray, 0.0F, getHeight(), Color.white);
	g2d.setPaint(gp);
	g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
