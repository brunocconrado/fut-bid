package br.com.futbid.swing.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.futbid.domain.Card;
import br.com.futbid.domain.Player;
import br.com.futbid.service.ImageService;
import br.com.futbid.swing.ui.event.PlayerSearchKeyListener;
import br.com.futbid.swing.ui.listener.AddPlayerActionListener;
import br.com.futbid.swing.ui.panel.option.Dialog;
import br.com.futbid.swing.ui.panel.option.OptionPanel;
import br.com.futbid.swing.ui.utils.Colors;

@org.springframework.stereotype.Component
public class PlayerFinderDialog extends JDialog implements Dialog, OptionPanel {

    private static final long serialVersionUID = 2014040701L;

    private JPanel contentTable;

    private JTextField searchField;
    
    private JPanel tableDataContainer;

    private Dialog parent;

    @Autowired
    private PlayerSearchKeyListener playerSearchKeyListener;

    @Autowired
    private ImageService imageService;

    public PlayerFinderDialog() {
	setTitle("Find and select player by name");
	setSize(640, 480);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(1);
	setAlwaysOnTop(true);
	setResizable(false);
    }

    @PostConstruct
    public void init() {
	setLayout(new BorderLayout());

	JPanel header = getHeaderPanel();
	JPanel tablePanel = new JPanel(new BorderLayout());
	tablePanel.setBackground(Color.white);
	JPanel finderPanel = createFinderPanel();
	contentTable = new JPanel();
	contentTable.setBackground(Color.white);

	tableDataContainer = new JPanel(new FlowLayout(1));
	tableDataContainer.setBackground(Color.white);

	JPanel controllPanel = getControlPanel();
	JScrollPane scrollPanel = new JScrollPane(tablePanel);

	scrollPanel.setPreferredSize(new Dimension(600, 400));
	scrollPanel.setVerticalScrollBarPolicy(22);
	scrollPanel.setHorizontalScrollBarPolicy(31);

	tableDataContainer.add(contentTable);

	tablePanel.setBackground(Colors.BACK_GROUND);
	tablePanel.add(header, "North");
	tablePanel.add(tableDataContainer, "Center");

	add(finderPanel, "North");
	add(scrollPanel, "Center");
	add(controllPanel, "South");
    }

    @Override
    public JDialog getDialog() {
	searchField.setText("");
	searchField.updateUI();
	return this;
    }

    @Override
    public void updateTable(List<Player> players) {
	tableDataContainer.removeAll();
	tableDataContainer.updateUI();
	
	contentTable = new JPanel();
	contentTable.setBackground(Color.white);
	contentTable.setLayout(new GridBagLayout());

	int verticanIndex = 0;

	GridBagConstraints c = new GridBagConstraints();
	c.fill = 2;
	for (final Player player : players) {
	    c.gridy = (verticanIndex++);
	    c.gridx = 0;

	    contentTable.add(getAsyncImagePanel(player.getClubImage()), c);

	    c.gridx = 1;
	    contentTable.add(getAsyncImagePanel(player.getNationImage()), c);

	    c.gridx = 2;
	    contentTable.add(getAsyncImagePanel(player.getImage()), c);

	    c.gridx = 3;
	    JLabel name = new JLabel(player.getFullName());
	    name.setPreferredSize(new Dimension(210, 40));
	    name.setHorizontalTextPosition(0);
	    name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    name.setFont(new Font("Arial", 1, 12));
	    contentTable.add(name, c);

	    c.gridx = 4;
	    JLabel position = new JLabel(player.getPosition().getValue());
	    position.setPreferredSize(new Dimension(50, 40));
	    position.setHorizontalTextPosition(0);
	    position.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    position.setFont(new Font("Arial", 1, 12));
	    contentTable.add(position, c);

	    c.gridx = 5;
	    JLabel rating = new JLabel(player.getRating().toString());
	    rating.setPreferredSize(new Dimension(50, 40));
	    rating.setHorizontalTextPosition(0);
	    rating.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    rating.setFont(new Font("Arial", 1, 12));
	    contentTable.add(rating, c);

	    c.gridx = 6;
 	    JButton action = new JButton("Select");
	    action.addActionListener(new AddPlayerActionListener(player, this));
	    action.setPreferredSize(new Dimension(80, 35));
	    contentTable.add(action, c);
	}

	contentTable.updateUI();
	tableDataContainer.add(contentTable);
	tableDataContainer.updateUI();
    }

    @Override
    public void setCardSelected(Card card) {
	((OptionPanel) parent).setCardSelected(card);
    }

    public Card getCardSelected() {
	return ((OptionPanel) parent).getCardSelected(); 
    }

    private Component getAsyncImagePanel(String url) {
	JPanel container = new JPanel();
	container.setBackground(Color.white);
	container.setPreferredSize(new Dimension(70, 40));
	imageService.loadImage(container, url);
	return container;
    }

    private JPanel getControlPanel() {
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(0, 30));
	panel.setBackground(Colors.BACK_GROUND);
	return panel;
    }

    private JPanel getHeaderPanel() {
	JPanel panel = new JPanel(new GridBagLayout());
	panel.setPreferredSize(new Dimension(0, 20));
	panel.setBackground(new Color(12, 132, 201));
	GridBagConstraints c = new GridBagConstraints();

	c.fill = 2;
	c.gridx = 0;
	c.gridy = 0;
	JLabel clubPic = new JLabel("Club");
	clubPic.setPreferredSize(new Dimension(70, 20));
	clubPic.setHorizontalTextPosition(0);
	clubPic.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	clubPic.setForeground(Colors.BACK_GROUND);
	clubPic.setFont(new Font("Arial", 1, 12));
	panel.add(clubPic, c);

	c.gridx = 1;
	JLabel countryPic = new JLabel("Country");
	countryPic.setPreferredSize(new Dimension(70, 20));
	countryPic.setHorizontalTextPosition(0);
	countryPic.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	countryPic.setForeground(Colors.BACK_GROUND);
	countryPic.setFont(new Font("Arial", 1, 12));
	panel.add(countryPic, c);

	c.gridx = 2;
	JLabel playerPic = new JLabel("Photo");
	playerPic.setPreferredSize(new Dimension(70, 20));
	playerPic.setHorizontalTextPosition(0);
	playerPic.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	playerPic.setForeground(Colors.BACK_GROUND);
	playerPic.setFont(new Font("Arial", 1, 12));
	panel.add(playerPic, c);

	c.gridx = 3;
	JLabel name = new JLabel("Player name");
	name.setPreferredSize(new Dimension(210, 20));
	name.setHorizontalTextPosition(0);
	name.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	name.setForeground(Colors.BACK_GROUND);
	name.setFont(new Font("Arial", 1, 12));
	panel.add(name, c);

	c.gridx = 4;
	JLabel position = new JLabel("Position");
	position.setPreferredSize(new Dimension(50, 20));
	position.setHorizontalTextPosition(0);
	position.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	position.setForeground(Colors.BACK_GROUND);
	position.setFont(new Font("Arial", 1, 12));
	panel.add(position, c);

	c.gridx = 5;
	JLabel rating = new JLabel("Rating");
	rating.setPreferredSize(new Dimension(50, 20));
	rating.setHorizontalTextPosition(0);
	rating.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	rating.setForeground(Colors.BACK_GROUND);
	rating.setFont(new Font("Arial", 1, 12));
	panel.add(rating, c);

	c.gridx = 6;
	JLabel action = new JLabel("Action");
	action.setPreferredSize(new Dimension(80, 20));
	action.setHorizontalTextPosition(0);
	action.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
	action.setForeground(Colors.BACK_GROUND);
	action.setFont(new Font("Arial", 1, 12));
	panel.add(action, c);

	return panel;
    }

    private JPanel createFinderPanel() {
	JPanel panel = new JPanel(new GridBagLayout());
	panel.setPreferredSize(new Dimension(0, 30));
	panel.setBackground(Colors.BACK_GROUND);
	GridBagConstraints c = new GridBagConstraints();

	c.fill = 2;
	c.gridx = 0;
	c.gridy = 0;
	JLabel label = new JLabel("Input player name: ");
	label.setPreferredSize(new Dimension(130, 30));
	panel.add(label, c);

	c.gridx = 1;
	this.searchField = new JTextField();
	this.searchField.addKeyListener(playerSearchKeyListener);
	this.searchField.setPreferredSize(new Dimension(300, 25));
	panel.add(this.searchField, c);

	return panel;
    }

    public void setVisible(boolean isVisible) {
	super.setVisible(isVisible);
	if (!isVisible) {
	    init();
	}
    }

    @Override
    public void setParent(Dialog parent) {
	this.parent = parent;
    }
}
