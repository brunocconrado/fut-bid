package br.com.futbid.swing.ui.panel.inventory.impl;

import static br.com.futbid.swing.ui.LabelFactory.createLable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Card;
import br.com.futbid.domain.Player;
import br.com.futbid.domain.enumeration.InventoryTypes;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.swing.ui.listener.BuyerInventoryClearActionListener;
import br.com.futbid.swing.ui.listener.InventoryDeleteActionListener;
import br.com.futbid.swing.ui.listener.InventorySelectActionListener;
import br.com.futbid.swing.ui.listener.InventoryTypesActionListener;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;
import br.com.futbid.swing.ui.panel.option.CardsOption;
import br.com.futbid.swing.ui.panel.option.OptionPanel;
import br.com.futbid.swing.ui.utils.Colors;
import br.com.futbid.swing.ui.utils.Utils;

@Component
public class BuyerInvetoryPanelImpl extends JPanel implements BuyerInvetoryPanel {

    private static final long serialVersionUID = 2014033101L;

    private static final Integer HORIZONTAL_POSITION = 0;

    private static final Integer FIRST = 0;

    private JPanel itemTablePanel;
    private JComboBox<InventoryTypes> typeComboBox;
    private JPanel tradeOptionPanel;
    private JScrollPane scrollPanel;
    private JPanel itemListPanel;
    private JPanel controlButtonPanel;

    private CardsOption<?> cardsOption;

    @Autowired
    private BuyerInventoryClearActionListener buyerInventoryClearActionListener;

    @Autowired
    private InventoryTypesActionListener inventoryTypesActionListener;

    @Autowired
    private Session session;

    private List<Player> players;

    public BuyerInvetoryPanelImpl() {
	itemTablePanel = new JPanel();
	itemTablePanel.setBackground(Colors.WHITE);

	itemListPanel = new JPanel(new BorderLayout());
	itemListPanel.setBackground(Colors.BACK_GROUND);

	scrollPanel = new JScrollPane(itemListPanel);
	scrollPanel.setBackground(Colors.BACK_GROUND);
	scrollPanel.setPreferredSize(new Dimension(0, 150));
	scrollPanel.setVerticalScrollBarPolicy(22);
	scrollPanel.setHorizontalScrollBarPolicy(31);

	controlButtonPanel = new JPanel(new FlowLayout(1));
	controlButtonPanel.setBackground(Color.WHITE);
	controlButtonPanel.setPreferredSize(new Dimension(190, 35));

	players = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
	typeComboBox = new JComboBox<>(InventoryTypes.values());
	typeComboBox.addActionListener(inventoryTypesActionListener);
	typeComboBox.setSelectedIndex(FIRST);

	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());

	JPanel headersPanel = new JPanel(new GridBagLayout());
	headersPanel.setBackground(Colors.HEADER_COLOR);

	GridBagConstraints gridBackConstraints = new GridBagConstraints();
	gridBackConstraints.fill = 2;
	gridBackConstraints.gridx = 0;
	gridBackConstraints.gridy = 0;
	JLabel numberLabel = createLable("#", null, Colors.BACK_GROUND, new Dimension(30, 20), HORIZONTAL_POSITION,
		true);
	numberLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Colors.white));
	headersPanel.add(numberLabel, gridBackConstraints);

	final MatteBorder matterBorder = BorderFactory.createMatteBorder(0, 1, 0, 1, Color.white);

	gridBackConstraints.gridx = 1;
	JLabel cardNameLabel = createLable("Type", null, Colors.BACK_GROUND, new Dimension(130, 20),
		HORIZONTAL_POSITION, true);
	cardNameLabel.setBorder(matterBorder);
	headersPanel.add(cardNameLabel, gridBackConstraints);

	gridBackConstraints.gridx = 2;
	JLabel identifierLabel = createLable("Identifier", null, Colors.BACK_GROUND, new Dimension(180, 20),
		HORIZONTAL_POSITION, true);
	identifierLabel.setBorder(matterBorder);
	headersPanel.add(identifierLabel, gridBackConstraints);

	gridBackConstraints.gridx = 3;
	JLabel buyPriceLabel = createLable("Buy Price", null, Colors.BACK_GROUND, new Dimension(80, 20),
		HORIZONTAL_POSITION, true);
	buyPriceLabel.setBorder(matterBorder);
	headersPanel.add(buyPriceLabel, gridBackConstraints);

	gridBackConstraints.gridx = 4;
	JLabel sellPriceLabel = createLable("Sell Price", null, Colors.BACK_GROUND, null, new Dimension(80, 20),
		HORIZONTAL_POSITION, true);
	sellPriceLabel.setBorder(matterBorder);
	headersPanel.add(sellPriceLabel, gridBackConstraints);

	gridBackConstraints.gridx = 5;
	JLabel formationLabel = createLable("Buy Price", null, Colors.BACK_GROUND, new Dimension(80, 20),
		HORIZONTAL_POSITION, true);
	formationLabel.setBorder(matterBorder);
	headersPanel.add(formationLabel, gridBackConstraints);

	gridBackConstraints.gridx = 6;
	gridBackConstraints.gridwidth = 2;
	JLabel actionLabel = createLable("Action", null, Colors.BACK_GROUND, new Dimension(200, 20),
		HORIZONTAL_POSITION, true);
	actionLabel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	headersPanel.add(actionLabel, gridBackConstraints);

	JPanel itemTableCenter = new JPanel(new FlowLayout(1));
	itemTableCenter.setBackground(Colors.WHITE);

	itemTableCenter.add(itemTablePanel);

	itemListPanel.add(headersPanel, "North");
	itemListPanel.add(itemTableCenter, "Center");

	//Aqui estava scroll panell

	JPanel configurationPanel = new JPanel(new BorderLayout());

	JButton clearAll = new JButton("Clear All");
	clearAll.addActionListener(buyerInventoryClearActionListener);

	JPanel itemTypePanel = new JPanel(new FlowLayout(0));
	itemTypePanel.setBackground(Colors.BACK_GROUND);
	itemTypePanel.add(clearAll);
	itemTypePanel.add(new JLabel(" or add :"));
	itemTypePanel.add(typeComboBox);

	tradeOptionPanel = new JPanel();
	tradeOptionPanel.setBackground(Colors.BACK_GROUND);

	configurationPanel.add(itemTypePanel, "North");
	configurationPanel.add(tradeOptionPanel, "Center");

	add(scrollPanel, "North");
	add(configurationPanel, "Center");
    }

    public void refreshSearchItemList() {
	itemTablePanel.removeAll();
	itemTablePanel.setBackground(Colors.WHITE);
	itemTablePanel.setLayout(new GridBagLayout());

	int verticalIndex = 0;
	for (final Card card : players) {

	    GridBagConstraints gridBagConstraints = new GridBagConstraints();
	    gridBagConstraints.fill = 2;
	    gridBagConstraints.gridx = 0;
	    gridBagConstraints.gridy = verticalIndex;

	    final MatteBorder matterBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);

	    JLabel numb = createLable(String.valueOf(verticalIndex + 1), null, new Dimension(30, 30),
		    HORIZONTAL_POSITION, true);
	    numb.setBorder(matterBorder);
	    itemTablePanel.add(numb, gridBagConstraints);

	    gridBagConstraints.gridx = 1;
	    JLabel cardLabel = createLable(card.getType().getValue(), null, new Dimension(130, 30),
		    HORIZONTAL_POSITION, true);
	    cardLabel.setBorder(matterBorder);
	    itemTablePanel.add(cardLabel, gridBagConstraints);

	    gridBagConstraints.gridx = 2;
	    JLabel l2 = createLable(card.getCardIdentifier(), null, new Dimension(180, 30), HORIZONTAL_POSITION, true);
	    l2.setBorder(matterBorder);
	    itemTablePanel.add(l2, gridBagConstraints);

	    gridBagConstraints.gridx = 3;
	    JLabel l3 = createLable(Utils.getString(card.getBuyPrice()), null, new Dimension(80, 30),
		    HORIZONTAL_POSITION, true);
	    l3.setBorder(matterBorder);
	    itemTablePanel.add(l3, gridBagConstraints);

	    gridBagConstraints.gridx = 4;
	    JLabel l4 = createLable(Utils.getString(card.getSellPrice()), null, new Dimension(80, 30),
		    HORIZONTAL_POSITION, true);
	    l4.setBorder(matterBorder);
	    itemTablePanel.add(l4, gridBagConstraints);

	    gridBagConstraints.gridx = 5;
	    String chemistryStyle = card.getChemistryStyle() != null ? card.getChemistryStyle().getDisplay() : " - ";
	    JLabel l5 = createLable(chemistryStyle, null, new Dimension(80, 30), HORIZONTAL_POSITION, true);
	    l5.setBorder(matterBorder);
	    itemTablePanel.add(l5, gridBagConstraints);

	    JPanel controlButtonPanel = new JPanel(new FlowLayout(1));
	    controlButtonPanel.setBackground(Color.WHITE);
	    controlButtonPanel.setPreferredSize(new Dimension(190, 35));

	    JButton selectButton = new JButton("Select");
	    selectButton.addActionListener(new InventorySelectActionListener(card, (OptionPanel) cardsOption));
	    controlButtonPanel.add(selectButton);

	    JButton deleteButton = new JButton("Delete");
	    deleteButton.addActionListener(new InventoryDeleteActionListener(card, this));
	    controlButtonPanel.add(deleteButton);

	    gridBagConstraints.gridx = 6;
	    gridBagConstraints.gridwidth = 2;
	    itemTablePanel.add(controlButtonPanel, gridBagConstraints);

	    verticalIndex++;
	}

	itemTablePanel.updateUI();
    }

    @Override
    public void changeOptionPanelByType(CardsOption<?> cardOption) {

	this.cardsOption = cardOption;

	tradeOptionPanel.removeAll();
	tradeOptionPanel.setLayout(new BorderLayout());
	tradeOptionPanel.add((JPanel) cardOption, "Center");
	tradeOptionPanel.updateUI();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void setCards(List<? extends Card> cards) {
	players = (List<Player>) cards;
	refreshSearchItemList();
    }

    @Override
    public <T extends Card> void addCards(T card) {
	players.add((Player) card);
	refreshSearchItemList();
    }

    @Override
    public OptionPanel getOptionPanel() {
	return (OptionPanel) cardsOption;
    }

}
