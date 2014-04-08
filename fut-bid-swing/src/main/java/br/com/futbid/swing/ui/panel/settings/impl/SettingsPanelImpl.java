package br.com.futbid.swing.ui.panel.settings.impl;

import static br.com.futbid.swing.ui.LabelFactory.createLable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Settings;
import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.domain.enumeration.search.ActionDuration;
import br.com.futbid.service.SettingsService;
import br.com.futbid.swing.ui.listener.ChangeFieldFormatterListener;
import br.com.futbid.swing.ui.listener.SettingsSaveActionListener;
import br.com.futbid.swing.ui.panel.settings.SettingsPanel;
import br.com.futbid.swing.ui.utils.Colors;

@Component
public class SettingsPanelImpl extends JPanel implements SettingsPanel {

    private static final long serialVersionUID = 2014022801L;

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private SettingsSaveActionListener settingsSaveActionListener;

    private JCheckBox logToFile;
    private JCheckBox dontBy;
    private JCheckBox stopBidWhenTradePileFull;
    private JTextField sleepTime;
    private JTextField tradePileSize;
    private JTextField maxBoughtCountPerMin;
    private JFormattedTextField minInWallet;
    private JComboBox<ActionDuration> auctionDuration;

    public SettingsPanelImpl() {
	logToFile = new JCheckBox();
	dontBy = new JCheckBox();
	stopBidWhenTradePileFull = new JCheckBox();
	sleepTime = new JTextField();
	tradePileSize = new JTextField();
	maxBoughtCountPerMin = new JTextField();
	minInWallet = new JFormattedTextField();
	auctionDuration = new JComboBox<>(ActionDuration.values());
    }

    @PostConstruct
    public void init() {
	setName(Tab.SETTINGS.getName());
	setLayout(new BorderLayout());

	JPanel controlPanel = new JPanel(new FlowLayout(2));
	controlPanel.setPreferredSize(new Dimension(0, 70));
	controlPanel.setBackground(Colors.BACK_GROUND);

	JButton saveButton = new JButton("Save");
	saveButton.addActionListener(settingsSaveActionListener);
	controlPanel.add(saveButton);

	add(createGeneralSettingsPanel(), "North");

	JPanel center = new JPanel(new BorderLayout());
	center.add(createBuyingAndSellingSettingsPanel(), "North");
	center.setBackground(Colors.BACK_GROUND);

	add(center, "Center");
	add(controlPanel, "South");

	updateFields();
    }

    private JPanel createBuyingAndSellingSettingsPanel() {

	GridLayout appLeftlayout = new GridLayout(4, 2);
	appLeftlayout.setVgap(20);

	JPanel leftPanel = new JPanel();
	leftPanel.setBackground(Colors.BACK_GROUND);
	leftPanel.setPreferredSize(new Dimension(470, 170));
	leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	leftPanel.setLayout(appLeftlayout);

	leftPanel.add(createLable("Stop biding if trade pile is full: ", Colors.BACK_GROUND));
	stopBidWhenTradePileFull.setBackground(Colors.BACK_GROUND);
	leftPanel.add(stopBidWhenTradePileFull);

	leftPanel.add(createLable("Max bought/bidded items per min.: ", Colors.BACK_GROUND));
	leftPanel.add(maxBoughtCountPerMin);

	leftPanel.add(createLable("Auction duration (hours): ", Colors.BACK_GROUND));
	auctionDuration.setSelectedIndex(0);
	leftPanel.add(auctionDuration);

	leftPanel.add(createLable("Minimal user coins left: ", Colors.BACK_GROUND));
	minInWallet = new JFormattedTextField(NumberFormat.getInstance());
	minInWallet.addPropertyChangeListener(new ChangeFieldFormatterListener());
	leftPanel.add(minInWallet);

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
	buyingSellSettingsPanel.add(
		createLable("Buying & Selling Settings: ", Colors.BACK_GROUND, Colors.FOREGROUND, null, null, false), "North");
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
	panel.add(createLable("Autobuyer will only relist, clear sold and analyze watch list items.",
		Colors.BACK_GROUND));
    }

    private void logFile(JPanel panel) {
	panel.add(createLable("Log to File: ", Colors.BACK_GROUND));

	logToFile.setBackground(Colors.BACK_GROUND);
	panel.add(this.logToFile);
    }

    private void sleepTime(JPanel panel) {
	panel.add(createLable("Sleep Time (seconds): ", Colors.BACK_GROUND));
	panel.add(sleepTime);
    }

    private void tradePileSize(JPanel panel) {
	panel.add(createLable("Trade pile size: ", Colors.BACK_GROUND));
	panel.add(tradePileSize);
    }

    private void dontBuy(JPanel panel) {
	panel.add(createLable("Don't Buy: ", Colors.BACK_GROUND));
	dontBy.setBackground(Colors.BACK_GROUND);
	panel.add(dontBy);
    }

    public void save() {
	settingsService.save(populateSettings());
    }

    @Override
    public void updateFields() {

	Settings settings = settingsService.find();
	logToFile.setSelected(settings.isLogToFile());
	dontBy.setSelected(settings.isDontBuy());
	stopBidWhenTradePileFull.setSelected(settings.isStopBidIfTradePileIsFull());

	sleepTime.setText(settings.getSleepTime() != null ? settings.getSleepTime().toString() : "");

	tradePileSize.setText(settings.getTradePileSize() != null ? settings.getTradePileSize().toString() : "");
	maxBoughtCountPerMin.setText(settings.getMaxBoughtCountPerMin() != null ? settings.getMaxBoughtCountPerMin()
		.toString() : "");

	auctionDuration.setSelectedItem(settings.getActionDuration());
	minInWallet.setValue(settings.getMinInWallet());

    }

    private Settings populateSettings() {

	Settings settings = settingsService.find();
	settings.setLogToFile(logToFile.isSelected());
	settings.setDontBuy(dontBy.isSelected());
	settings.setStopBidIfTradePileIsFull(stopBidWhenTradePileFull.isSelected());

	settings.setSleepTime(formatLong(sleepTime.getText()));

	settings.setTradePileSize(formatInteger(tradePileSize.getText()));
	settings.setMaxBoughtCountPerMin(formatInteger(maxBoughtCountPerMin.getText()));

	settings.setActionDuration((ActionDuration) auctionDuration.getSelectedItem());

	settings.setMinInWallet((Long) minInWallet.getValue());

	return settings;
    }

    private Long formatLong(String text) {
	try {
	    return Long.parseLong(text);
	} catch (NumberFormatException e) {
	    return 0L;
	}
    }

    private Integer formatInteger(String text) {
	try {
	    return Integer.parseInt(text);
	} catch (NumberFormatException e) {
	    return 0;
	}
    }

}
