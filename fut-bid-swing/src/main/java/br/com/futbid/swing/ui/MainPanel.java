package br.com.futbid.swing.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.swing.ui.listener.ChangeTabListener;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;
import br.com.futbid.swing.ui.panel.settings.SettingsPanel;
import br.com.futbid.swing.ui.panel.tab.WorkTabPanel;

@org.springframework.stereotype.Component
public class MainPanel extends JPanel {

    private static final Logger LOG = LoggerFactory.getLogger(MainPanel.class);

    private static final long serialVersionUID = 2014030102L;

    @Autowired
    private SettingsPanel settingsPanel;

    @Autowired
    private AuthenticationPainel authenticationPanel;

    @Autowired
    private WorkTabPanel workTabPanel;

    @Autowired
    private BuyerInvetoryPanel buyerInvetoryPanel;

    public MainPanel() {
    }

    @PostConstruct
    public void init() {
	setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

	final JTabbedPane tabPanel = new JTabbedPane();
	tabPanel.setPreferredSize(new Dimension(800, 550));

	tabPanel.addTab(Tab.BUY.getName(), (Component) buyerInvetoryPanel);
	tabPanel.addTab(Tab.LOGIN.getName(), (Component) workTabPanel);
	tabPanel.addTab(Tab.SETTINGS.getName(), (Component) settingsPanel);
	

	/*
	 * tabPanel.addTab("Buyer inventory", this.buyIP); tabPanel.addTab("Bidder inventory", this.bidIP);
	 */

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
