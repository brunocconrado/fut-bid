package br.com.futbid.swing.ui.panel.option.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.enumeration.ChemistryStyle;
import br.com.futbid.domain.enumeration.Country;
import br.com.futbid.domain.enumeration.League;
import br.com.futbid.domain.enumeration.Level;
import br.com.futbid.domain.enumeration.Position;
import br.com.futbid.domain.enumeration.Team;
import br.com.futbid.domain.search.SubType;
import br.com.futbid.domain.search.Type;
import br.com.futbid.service.PlayerService;
import br.com.futbid.swing.ui.dialog.PlayerFinderDialog;
import br.com.futbid.swing.ui.event.BuyPriceKeyListener;
import br.com.futbid.swing.ui.event.SellPriceKeyListener;
import br.com.futbid.swing.ui.listener.DeleteButtonActionListener;
import br.com.futbid.swing.ui.listener.SavePlayerActionListener;
import br.com.futbid.swing.ui.listener.SelectPlayerButtonListener;
import br.com.futbid.swing.ui.panel.option.CardsOption;
import br.com.futbid.swing.ui.panel.option.Dialog;
import br.com.futbid.swing.ui.panel.option.OptionPanel;
import br.com.futbid.swing.ui.utils.Colors;
import br.com.futbid.swing.ui.utils.Utils;

@Component
public class PlayerOptionPanel extends JPanel implements Dialog, OptionPanel, CardsOption<Player> {

    private static final long serialVersionUID = 2014040702L;

    private JTextField playerNameField;
    private JTextField buyPriceField;
    private JTextField sellPriceField;
    private JTextField pageResultSize;
    private JTextField pageCount;
    private JTextField cardRatingField;
    private JComboBox<Level> levelField;
    private JComboBox<Team> teamField;
    private JComboBox<Country> countryField;
    private JComboBox<League> leagueField;
    private JComboBox<Position> positionField;
    private JComboBox<ChemistryStyle> chemistryStyleField;

    private JLabel profitLabel;

    private JButton deleteBtn;
    private JButton selectBtn;
    private JButton addPlayerButton;

    @Autowired
    private SavePlayerActionListener savePlayerActionListener;

    @Autowired
    private SelectPlayerButtonListener selectPlayerButtonListener;

    @Autowired
    private DeleteButtonActionListener deleteButtonActionListener;

    @Autowired
    private BuyPriceKeyListener buyPriceKeyListener;

    @Autowired
    private SellPriceKeyListener sellPriceKeyListener;

    @Autowired
    private PlayerFinderDialog playerFinderDialog;
    
    @Autowired
    private PlayerService playerService;

    private Player playerSelected;

    public PlayerOptionPanel() {
    }

    @PostConstruct
    public void init() {

	selectPlayerButtonListener.setParent(this);

	playerNameField = new JTextField();
	playerNameField.setEditable(false);
	playerNameField.setPreferredSize(new Dimension(145, 30));

	selectBtn = new JButton(new ImageIcon(getClass().getResource("/select.png")));
	selectBtn.setPreferredSize(new Dimension(20, 30));
	selectBtn.addActionListener(selectPlayerButtonListener);

	deleteBtn = new JButton(new ImageIcon(getClass().getResource("/remove.png")));
	deleteBtn.setEnabled(false);
	deleteBtn.addActionListener(deleteButtonActionListener);
	deleteBtn.setPreferredSize(new Dimension(20, 30));

	levelField = new JComboBox<>(Level.values());
	levelField.setSelectedIndex(0);

	buyPriceField = new JTextField();
	buyPriceField.addKeyListener(buyPriceKeyListener);

	sellPriceField = new JTextField("250");
	sellPriceField.addKeyListener(sellPriceKeyListener);

	teamField = new JComboBox<>(Team.values());
	teamField.setSelectedIndex(0);

	countryField = new JComboBox<>(Country.values());
	countryField.setSelectedIndex(0);

	leagueField = new JComboBox<>(League.values());
	leagueField.setSelectedIndex(0);

	positionField = new JComboBox<>(Position.values());
	positionField.setSelectedIndex(0);

	chemistryStyleField = new JComboBox<>(ChemistryStyle.values());
	chemistryStyleField.setSelectedIndex(0);

	pageResultSize = new JTextField(16);
	pageCount = new JTextField(1);
	cardRatingField = new JTextField();
	profitLabel = new JLabel("");

	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());

	JPanel centerPanel = getCenterPanel();

	JPanel bottom = new JPanel(new FlowLayout(0));
	bottom.setBackground(Colors.BACK_GROUND);

	addPlayerButton = new JButton("Add");
	addPlayerButton.addActionListener(savePlayerActionListener);
	bottom.add(addPlayerButton);

	add(centerPanel, "North");
	add(bottom, "Center");

    }

    private JPanel getCenterPanel() {
	JPanel panel = new JPanel();
	panel.setBackground(Colors.BACK_GROUND);
	GridLayout layout = new GridLayout(6, 4);
	layout.setVgap(20);
	layout.setHgap(10);
	panel.setLayout(layout);

	panel.add(new JLabel("Player Name: "));

	JPanel playerSelectorContainer = new JPanel(new GridBagLayout());
	playerSelectorContainer.setBackground(Colors.BACK_GROUND);
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	gridBagConstraints.fill = 2;
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 0;

	playerSelectorContainer.add(playerNameField, gridBagConstraints);
	gridBagConstraints.gridx = 1;

	playerSelectorContainer.add(selectBtn, gridBagConstraints);
	gridBagConstraints.gridx = 2;

	playerSelectorContainer.add(deleteBtn, gridBagConstraints);
	panel.add(playerSelectorContainer);

	panel.add(new JLabel("Level: "));
	panel.add(levelField);

	//panel.add(new JLabel(isBuyerMode() ? "Buy Price (>=200): " : "Max bid Price (>=150): "));
	panel.add(new JLabel("Buy Price (>=200): "));
	panel.add(buyPriceField);

	panel.add(new JLabel("Sell Price: "));
	panel.add(sellPriceField);

	panel.add(new JLabel("Details: "));
	panel.add(teamField);
	panel.add(countryField);
	panel.add(this.leagueField);

	panel.add(new JLabel("Position: "));
	panel.add(this.positionField);

	panel.add(new JLabel("Chemistry Style: "));
	panel.add(this.chemistryStyleField);

	panel.add(new JLabel("Page result (12-16): "));
	panel.add(pageResultSize);

	panel.add(new JLabel("Pages count (1-16): "));
	panel.add(pageCount);

	panel.add(new JLabel("Card Rating: "));
	panel.add(cardRatingField);

	panel.add(new JLabel("Profit: "));
	panel.add(profitLabel);

	return panel;
    }

    @Override
    public void setPlayerSelected(Player player) {
	playerSelected = player;

	playerNameField.setText(player.getFullName());

	teamField.setEnabled(false);
	countryField.setEnabled(false);
	leagueField.setEnabled(false);
	positionField.setEditable(false);
	deleteBtn.setEnabled(true);
	playerFinderDialog.setVisible(false);
	cardRatingField.setText(player.getRating().toString());
	for (Position position : Position.values()) {
	    if (position.equals(player.getPosition())) {
		positionField.setSelectedItem(position);
		break;
	    }
	}
	calculateProfit();
    }

    @Override
    public Player getPlayerSelected() {
	createPlayerSearchItem();
	return playerSelected;
    }

    private void removeSelectedPlayerInfo() {
	playerNameField.setText("");

	levelField.setEnabled(true);
	teamField.setEnabled(true);
	countryField.setEnabled(true);
	leagueField.setEnabled(true);
	deleteBtn.setEnabled(false);
    }

    public void clearAllFields() {
	playerNameField.setText("");
	levelField.setSelectedIndex(0);
	buyPriceField.setText("");
	sellPriceField.setText("");
	teamField.setSelectedIndex(0);
	countryField.setSelectedIndex(0);
	positionField.setSelectedIndex(0);
	leagueField.setSelectedIndex(0);
	chemistryStyleField.setSelectedIndex(0);
	cardRatingField.setText("");
	profitLabel.setText("");
	pageResultSize.setText(String.valueOf(16));
	pageCount.setText(String.valueOf(1));
    }

    protected void calculateProfit() {
	Double result = Utils.calculateProfit(Utils.parseDouble(buyPriceField.getText()),
		Utils.parseDouble(sellPriceField.getText()));
	profitLabel.setText(result == null ? "" : result.toString());
    }

    public boolean isSelected(Player player) {
	return playerSelected.equals(player);
    }

    @Override
    public JDialog getDialog() {
	playerFinderDialog.getDialog();
	return playerFinderDialog;
    }

    @Override
    public void updateTable(List<Player> players) {
	//no-op
	throw new IllegalStateException("Method not implemented");
    }

    @Override
    public void setParent(Dialog parent) {
	//no-op
    }

    public void selectMode(Player player) {
	playerSelected = player;
	addPlayerButton.setText("Save");
	removeSelectedPlayerInfo();

	buyPriceField.setText(player.getBuyPrice().toString());
	sellPriceField.setText(player.getSellPrice().toString());

	positionField.setSelectedItem(Position.findBy(player.getPosition()));
	chemistryStyleField.setSelectedItem(ChemistryStyle.findBy(player.getChemistryStyle()));
	leagueField.setSelectedItem(League.findBy(player.getLeague()));
	countryField.setSelectedItem(Country.findBy(player.getCountry()));
	teamField.setSelectedItem(Team.findBy(player.getTeam()));
	levelField.setSelectedItem(Level.findBy(player.getLevel()));

	cardRatingField.setText(player.getCardRating());
	pageResultSize.setText(player.getMaxPageRes());
	pageCount.setText(String.valueOf(player.getMaxPageCount()));
	calculateProfit();
    }

    private boolean createPlayerSearchItem() {

	if (playerSelected == null) {
	    playerSelected = new Player();
	}

	//playerSelected.setSubType(SubType.CHEMISTRY);
	playerSelected.setLevel((Level) levelField.getSelectedItem());
	playerSelected.setTeam((Team) teamField.getSelectedItem());
	playerSelected.setCountry((Country) countryField.getSelectedItem());
	playerSelected.setLeague((League) leagueField.getSelectedItem());
	playerSelected.setBuyPrice(Utils.parseDouble(buyPriceField.getText()));
	playerSelected.setSellPrice(Utils.parseDouble(sellPriceField.getText()));
	playerSelected.setPosition((Position) positionField.getSelectedItem());
	playerSelected.setChemistryStyle((ChemistryStyle) chemistryStyleField.getSelectedItem());
	playerSelected.setCardRating(cardRatingField.getText());
	playerSelected.setMaxPageRes(pageResultSize.getText());
	playerSelected.setMaxPageCount(Utils.parseInt(pageCount.getText()));
	playerSelected.setType(Type.PLAYER);
	
	clearAllFields();
	removeSelectedPlayerInfo();

	return true;
    }

    @Override
    public List<Player> getCards() {
	return playerService.findAll();
    }

}
