package br.com.futbid.swing.ui.settings.impl;

import static br.com.futbid.swing.ui.LabelFactory.createLable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.futbid.domain.Settings;
import br.com.futbid.service.SettingsService;
import br.com.futbid.service.impl.SettingsServiceImpl;
import br.com.futbid.swing.ui.enumeration.search.SellTime;
import br.com.futbid.swing.ui.listener.SettingsSaveActionListener;
import br.com.futbid.swing.ui.settings.SettingsPanel;
import br.com.futbid.swing.ui.utils.Colors;

public class SettingsPanelImpl extends JPanel implements SettingsPanel {

    private static final long serialVersionUID = 2014022801L;

    private SettingsService settingsService = new SettingsServiceImpl();

    private Settings settings;

    private JCheckBox logToFileField;
    private JTextField sleepTimeFiled;
    private JTextField tradePileSizeField;
    private JCheckBox dontByField;
    private JCheckBox stopBidWhenTradePileFull;
    private JTextField maxBoughtCountPerMin;
    private JComboBox auctionDuration;
    private JTextField minCoinsValue;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SettingsPanelImpl() {

	settings = settingsService.find();

	setLayout(new BorderLayout());
	
	JPanel controlPanel = new JPanel(new FlowLayout(2));
	controlPanel.setPreferredSize(new Dimension(0, 70));
	controlPanel.setBackground(Colors.BACK_GROUND);

	JButton saveButton = new JButton("Save");
	saveButton.addActionListener(new SettingsSaveActionListener());
	controlPanel.add(saveButton);

	add(createGeneralSettingsPanel(), "North");
	
	JPanel center = new JPanel(new BorderLayout());
	center.add(createBuyingAndSellingSettingsPanel(), "North");
	center.setBackground(Colors.BACK_GROUND);
	
	add(center, "Center");
	add(controlPanel, "South");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private JPanel createBuyingAndSellingSettingsPanel() {

	GridLayout appLeftlayout = new GridLayout(4, 2);
	appLeftlayout.setVgap(20);
	
	JPanel leftPanel = new JPanel();
	leftPanel.setBackground(Colors.BACK_GROUND);
	leftPanel.setPreferredSize(new Dimension(470, 170));
	leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	leftPanel.setLayout(appLeftlayout);
	
	leftPanel.add(createLable("Stop biding if trade pile is full: ", Colors.BACK_GROUND));
	stopBidWhenTradePileFull = new JCheckBox();
	stopBidWhenTradePileFull.setBackground(Colors.BACK_GROUND);
	leftPanel.add(stopBidWhenTradePileFull);

	leftPanel.add(createLable("Max bought/bidded items per min.: ", Colors.BACK_GROUND));
	maxBoughtCountPerMin = new JTextField();
	leftPanel.add(maxBoughtCountPerMin);

	leftPanel.add(createLable("Auction duration (hours): ", Colors.BACK_GROUND));
	auctionDuration = new JComboBox(SellTime.values());
	auctionDuration.setSelectedIndex(0);
	leftPanel.add(auctionDuration);

	leftPanel.add(createLable("Minimal user coins left: ", Colors.BACK_GROUND));
	minCoinsValue = new JTextField();
	leftPanel.add(minCoinsValue);

	GridLayout rightLayout = new GridLayout(4, 1);
	rightLayout.setVgap(20);
	
	JPanel rightPanel = new JPanel();
	rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	rightPanel.setBackground(Colors.BACK_GROUND);
	rightPanel.setLayout(rightLayout);
	rightPanel.add(createLable("Application stop bidding if trade pile is full.", Colors.BACK_GROUND));
	rightPanel.add(createLable("Maximal bought items per minute.", Colors.BACK_GROUND));
	rightPanel.add(createLable("Auction duration.", Colors.BACK_GROUND));
	rightPanel.add(createLable("Program will shutdown if reached.", Colors.BACK_GROUND));

	JPanel appCenterPanel = new JPanel(new BorderLayout());
	appCenterPanel.setBackground(Colors.BACK_GROUND);
	appCenterPanel.add(leftPanel, "West");
	appCenterPanel.add(rightPanel, "East");
	
	JPanel buyingSellSettingsPanel = new JPanel(new BorderLayout());
	buyingSellSettingsPanel.setBackground(Colors.BACK_GROUND);
	buyingSellSettingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	buyingSellSettingsPanel.add(createLable("Buying & Selling Settings: ", Colors.BACK_GROUND, Colors.FOREGROUND), "North");
	buyingSellSettingsPanel.add(appCenterPanel, "Center");

	return buyingSellSettingsPanel;
	
    }

    private JPanel createGeneralSettingsPanel() {
	
	JPanel settingsPanel = new JPanel(new BorderLayout());
	settingsPanel.setBackground(Colors.BACK_GROUND);
	settingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
	JLabel generalSettingsLabel = new JLabel("General Settings: ");
	generalSettingsLabel.setBackground(Colors.BACK_GROUND);
	generalSettingsLabel.setForeground(new Color(12, 132, 201));
	generalSettingsLabel.setFont(new Font("Arial", 1, 14));

	GridLayout layout = new GridLayout(4, 2);
	layout.setVgap(20);

	//Left Panel
	JPanel leftPanel = new JPanel();
	leftPanel.setBackground(Colors.BACK_GROUND);
	leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	leftPanel.setLayout(layout);

	logFile(leftPanel);
	sleepTime(leftPanel);
	tradePileSize(leftPanel);
	dontBuy(leftPanel);

	GridLayout hintLayout = new GridLayout(4, 1);
	hintLayout.setVgap(20);

	//Right Panel
	JPanel rightPanel = new JPanel();
	rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	rightPanel.setBackground(Colors.BACK_GROUND);
	rightPanel.setLayout(hintLayout);
	createDescriptionMessage(rightPanel);

	JPanel centerPanel = new JPanel(new BorderLayout());
	centerPanel.setBackground(Colors.BACK_GROUND);
	centerPanel.add(leftPanel, "West");
	centerPanel.add(rightPanel, "East");

	settingsPanel.add(generalSettingsLabel, "North");
	settingsPanel.add(centerPanel, "Center");
	
	return settingsPanel;
    }

    private void createDescriptionMessage(JPanel panel) {
	panel.add(createLable("Save all the logs from logfeed into a file.", Colors.BACK_GROUND));
	panel.add(createLable("Number of miliseconds that bot will sleep.", Colors.BACK_GROUND));
	panel.add(createLable("Trade pile size", Colors.BACK_GROUND));
	panel.add(createLable("Autobuyer will only relist, clear sold and analyze watch list items.", Colors.BACK_GROUND));
    }

    private void logFile(JPanel panel) {
	panel.add(createLable("Log to File: ", Colors.BACK_GROUND));

	logToFileField = new JCheckBox();
	logToFileField.setBackground(Colors.BACK_GROUND);
	panel.add(this.logToFileField);
    }

    private void sleepTime(JPanel panel) {
	panel.add(createLable("Sleep Time (seconds): ", Colors.BACK_GROUND));

	sleepTimeFiled = new JTextField();
	panel.add(sleepTimeFiled);
    }

    private void tradePileSize(JPanel panel) {
	panel.add(createLable("Trade pile size: ", Colors.BACK_GROUND));

	tradePileSizeField = new JTextField();
	panel.add(tradePileSizeField);
    }

    private void dontBuy(JPanel panel) {
	panel.add(createLable("Don't Buy: ", Colors.BACK_GROUND));

	dontByField = new JCheckBox();
	dontByField.setBackground(Colors.BACK_GROUND);
	panel.add(dontByField);
    }
    
    public void save() {
	/*
	 * ApplicationParametersManager.INSTANCE().saveNewValues(this.logToFileField.isSelected(),
	 * this.sleepTimeFiled.getText(), this.tradePileSizeField.getText(), this.dontByField.isSelected(),
	 * this.maxBoughtCountPerMin.getText(), ((SearchFields.AuctionDuration)
	 * this.auctionDuration.getSelectedItem()).getValue(), this.minCoinsValue.getText(),
	 * this.stopBidWhenTradePileFull.isSelected());
	 */
    }

    @Override
    public void updateFields() {
	/*
	 * this.logToFileField.setSelected(ApplicationParametersManager.INSTANCE().isLogToFile());
	 * this.sleepTimeFiled.setText(ApplicationParametersManager.INSTANCE().getSleepTimeInSeconds() + "");
	 * this.tradePileSizeField.setText(String.valueOf(ApplicationParametersManager.INSTANCE().getTradePileSize()));
	 * 
	 * this.dontByField.setSelected(ApplicationParametersManager.INSTANCE().isDontBuy());
	 * this.maxBoughtCountPerMin.setText(ApplicationParametersManager.INSTANCE().getMaxBoughtCountPerMin() + "");
	 * for (SearchFields.AuctionDuration ad : SearchFields.AuctionDuration.values()) { if (ad.getValue() ==
	 * ApplicationParametersManager.INSTANCE().getAuctionDuration()) { this.auctionDuration.setSelectedItem(ad); } }
	 * this.minCoinsValue.setText(ApplicationParametersManager.INSTANCE().getMinCoinsValue() + "");
	 * this.stopBidWhenTradePileFull
	 * .setSelected(ApplicationParametersManager.INSTANCE().isStopBidIfTradePileIsFull());
	 */
    }

}
