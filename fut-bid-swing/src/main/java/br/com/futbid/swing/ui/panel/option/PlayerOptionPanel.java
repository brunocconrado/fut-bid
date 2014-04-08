package br.com.futbid.swing.ui.panel.option;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import br.com.futbid.swing.ui.dialog.PlayerFinderDialog;
import br.com.futbid.swing.ui.event.BuyPriceKeyListener;
import br.com.futbid.swing.ui.event.SellPriceKeyListener;
import br.com.futbid.swing.ui.listener.AddPlayerActionListener;
import br.com.futbid.swing.ui.listener.DeleteButtonActionListener;
import br.com.futbid.swing.ui.listener.SelectButtonListener;
import br.com.futbid.swing.ui.utils.Colors;
import br.com.futbid.swing.ui.utils.Utils;

@Component
public class PlayerOptionPanel extends BaseOptionPanel {

    private static final long serialVersionUID = 2014040701L;

    private Player playerSelected;
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
    private AddPlayerActionListener addPlayerActionListener;

    @Autowired
    private SelectButtonListener selectButtonListener;

    @Autowired
    private DeleteButtonActionListener deleteButtonActionListener;

    @Autowired
    private BuyPriceKeyListener buyPriceKeyListener;

    @Autowired
    private SellPriceKeyListener sellPriceKeyListener;

    @Autowired
    private PlayerFinderDialog playerFinderDialog;

    //private PlayerSearchItem selectItem = null;

    public PlayerOptionPanel() {

	//this.parentPanel = parent;

	playerNameField = new JTextField();
	playerNameField.setEditable(false);
	playerNameField.setPreferredSize(new Dimension(145, 30));

	selectBtn = new JButton(new ImageIcon(getClass().getResource("/select.png")));
	selectBtn.setPreferredSize(new Dimension(20, 30));
	selectBtn.addActionListener(selectButtonListener);

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

	this.leagueField = new JComboBox<>(League.values());
	this.leagueField.setSelectedIndex(0);

	this.positionField = new JComboBox<>(Position.values());
	this.positionField.setSelectedIndex(0);

	this.chemistryStyleField = new JComboBox<>(ChemistryStyle.values());
	this.chemistryStyleField.setSelectedIndex(0);

	this.pageResultSize = new JTextField(16);
	this.pageCount = new JTextField(1);
	this.cardRatingField = new JTextField();
	this.profitLabel = new JLabel("");

	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());

	JPanel centerPanel = getCenterPanel();

	JPanel bottom = new JPanel(new FlowLayout(0));
	bottom.setBackground(Colors.BACK_GROUND);

	addPlayerButton = new JButton("Add");
	addPlayerButton.addActionListener(addPlayerActionListener);
	bottom.add(addPlayerButton);

	add(centerPanel, "North");
	add(bottom, "Center");

	/*
	 * playerFinderDialog = new PlayerFinderPanel() { private static final long serialVersionUID = 1L;
	 * 
	 * public void setVisible(boolean b) { PlayerOptionPanel.this.addPlayerButton.setEnabled(!b);
	 * super.setVisible(b); }
	 * 
	 * public void selectPlayer(PlayerInfo pi) { if (pi != null) { PlayerOptionPanel.this.setPlayerInfo(pi); } } };
	 */
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

	playerSelectorContainer.add(this.playerNameField, gridBagConstraints);
	gridBagConstraints.gridx = 1;

	playerSelectorContainer.add(this.selectBtn, gridBagConstraints);
	gridBagConstraints.gridx = 2;

	playerSelectorContainer.add(this.deleteBtn, gridBagConstraints);
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

    private void setPlayer(Player player) {
	playerSelected = player;

	this.playerNameField.setText(player.getFullName());

	this.levelField.setEnabled(false);
	this.teamField.setEnabled(false);
	this.countryField.setEnabled(false);
	this.leagueField.setEnabled(false);

	this.deleteBtn.setEnabled(true);

	playerFinderDialog.setVisible(false);

	this.cardRatingField.setText(player.getRating() + "");
	for (Position p : Position.values()) {
	    if (p.equals(player.getPosition())) {
		this.positionField.setSelectedItem(p);
		break;
	    }
	}
	calculateProfit();
    }

    private void removeSelectedPlayerInfo() {
	playerSelected = null;

	playerNameField.setText("");

	levelField.setEnabled(true);
	teamField.setEnabled(true);
	countryField.setEnabled(true);
	leagueField.setEnabled(true);
	deleteBtn.setEnabled(false);
    }

    private boolean createPlayerSearchItem() {

	if (playerSelected == null) {
	    playerSelected = new Player();
	}

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

	clearAllFields();
	removeSelectedPlayerInfo();

	return true;
    }

    public void clearAllFields() {
	this.playerNameField.setText("");
	this.levelField.setSelectedIndex(0);
	this.buyPriceField.setText("");

	this.sellPriceField.setText("");
	this.teamField.setSelectedIndex(0);
	this.countryField.setSelectedIndex(0);
	this.positionField.setSelectedIndex(0);
	this.leagueField.setSelectedIndex(0);
	this.chemistryStyleField.setSelectedIndex(0);
	this.cardRatingField.setText("");
	this.profitLabel.setText("");
	this.pageResultSize.setText(String.valueOf(16));
	this.pageCount.setText(String.valueOf(1));
    }

    public void selectMode(Player player) {
	playerSelected = player;
	addPlayerButton.setText("Save");
	setPlayer(player);
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

    protected void calculateProfit() {
	Double result = Utils.calculateProfit(Utils.parseDouble(buyPriceField.getText()),
		Utils.parseDouble(sellPriceField.getText()));
	profitLabel.setText(result == null ? "" : result.toString());
    }

    public boolean isSelected(Player sp) {
	return playerSelected.equals(sp);
    }
}
