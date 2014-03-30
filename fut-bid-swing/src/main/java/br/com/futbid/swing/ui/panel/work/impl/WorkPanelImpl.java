package br.com.futbid.swing.ui.panel.work.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.BiddedModelView;
import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.service.AutoBuyerService;
import br.com.futbid.swing.ui.WorkProcessListener;
import br.com.futbid.swing.ui.listener.AutoBidderActionListener;
import br.com.futbid.swing.ui.listener.AutoBuyerActionLister;
import br.com.futbid.swing.ui.listener.LogoutActionListener;
import br.com.futbid.swing.ui.listener.StartActionListener;
import br.com.futbid.swing.ui.panel.work.WorkPanel;
import br.com.futbid.swing.ui.utils.Colors;

@Component
public class WorkPanelImpl extends JPanel implements WorkPanel {

    private static final long serialVersionUID = 2014031101L;

    @Autowired
    private AutoBuyerService autoBuyerService;

    @Autowired
    private StartActionListener startActionListener;

    @Autowired
    private AutoBidderActionListener autoBidderActionListener;

    @Autowired
    private AutoBuyerActionLister autoBuyerActionLister;

    @Autowired
    private Session session;

    private JButton workControllButton;
    private JRadioButton autobuyerMode;
    private JRadioButton autobidderMode;
    private JPanel biddedItemTablePanel;
    private JPanel biddedItemTable;
    private JTextArea logField;
    private JLabel applciationStatusLabel;
    private JLabel currentActionLabel;
    private JLabel currentBalanceLebel;
    private JLabel currentBoughtItemLabel;
    private JLabel currentSoldItemLabel;
    private JLabel currentAuctionSizeLabel;
    private JLabel watchListLable;
    private boolean doLogout;

    private List<BiddedModelView> biddedModels = new ArrayList<BiddedModelView>();

    public WorkPanelImpl() {
    }

    @PostConstruct
    public void init() {

	setName(Tab.WORK.getName());
	
	autoBuyerService.addListener(new WorkProcessListener());

	setBackground(Colors.BACK_GROUND);
	setLayout(new BorderLayout());

	JPanel top = buildTop();
	JPanel center = buildCenter();
	JPanel bottom = buildBottom();

	add(top, "North");
	add(center, "Center");
	add(bottom, "South");
    }

    private JPanel buildBottom() {
	JPanel panel = new JPanel();

	panel.setBackground(Colors.BACK_GROUND);

	this.autobuyerMode = new JRadioButton("Autobuyer");
	this.autobidderMode = new JRadioButton("Autobidder");

	this.autobuyerMode.setBackground(Colors.BACK_GROUND);
	this.autobidderMode.setBackground(Colors.BACK_GROUND);

	this.autobuyerMode.setSelected(true);

	//SessionManager.INSTANCE().setApplicationMode(SessionManager.ApplicationMode.AUTOBUYER);

	this.autobuyerMode.addActionListener(autoBuyerActionLister);
	this.autobidderMode.addActionListener(autoBidderActionListener);

	workControllButton = new JButton("Start");
	workControllButton.addActionListener(startActionListener);
	panel.add(new JLabel("Select application mode: "));
	panel.add(autobuyerMode);
	panel.add(autobidderMode);
	panel.add(workControllButton);

	return panel;
    }

    private JPanel buildCenter() {
	JPanel panel = new JPanel(new BorderLayout());

	panel.setBackground(Colors.BACK_GROUND);

	JPanel loggingPanel = new JPanel(new BorderLayout());

	this.logField = new JTextArea();
	this.logField.setEditable(false);

	JPanel statusPanel = new JPanel(new GridLayout(5, 2));
	statusPanel.setBackground(Colors.BACK_GROUND);

	statusPanel.add(new JLabel("Current action: "));
	statusPanel.add(this.currentActionLabel = new JLabel("Stopped"));
	statusPanel.add(new JLabel("Balance: "));
	statusPanel.add(this.currentBalanceLebel = new JLabel("0"));
	statusPanel.add(new JLabel("Bought items: "));
	statusPanel.add(this.currentBoughtItemLabel = new JLabel("0"));
	statusPanel.add(new JLabel("Listed items: "));
	statusPanel.add(this.currentAuctionSizeLabel = new JLabel("0"));
	statusPanel.add(new JLabel("Sold items: "));
	statusPanel.add(this.currentSoldItemLabel = new JLabel("0"));

	JScrollPane centerScrollPanel = new JScrollPane(this.logField);
	centerScrollPanel.setPreferredSize(new Dimension(0, 300));
	centerScrollPanel.setVerticalScrollBarPolicy(22);
	centerScrollPanel.setHorizontalScrollBarPolicy(30);

	biddedItemTablePanel = getBittedItemTablePanel();

	loggingPanel.add(centerScrollPanel, "Center");
	loggingPanel.add(this.biddedItemTablePanel, "East");

	panel.add(loggingPanel, "North");
	panel.add(statusPanel, "Center");

	return panel;
    }

    private JPanel getBittedItemTablePanel() {
	JPanel panel = new JPanel();
	JPanel header = new JPanel(new GridBagLayout());
	JPanel container = new JPanel(new BorderLayout());
	JScrollPane scrollPanel = new JScrollPane(container);

	GridBagConstraints c = new GridBagConstraints();

	panel.setLayout(new BorderLayout());
	panel.setVisible(false);
	panel.setPreferredSize(new Dimension(400, 100));
	panel.setBackground(Colors.BACK_GROUND);
	this.watchListLable = new JLabel("Watch list:");
	panel.add(this.watchListLable, "North");
	panel.add(scrollPanel, "Center");

	header.setPreferredSize(new Dimension(375, 20));
	header.setBackground(Colors.HEADER_COLOR);

	c.fill = 2;
	c.gridx = 0;
	c.gridy = 0;

	JLabel numb = new JLabel("#");
	numb.setHorizontalTextPosition(0);
	numb.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
	numb.setPreferredSize(new Dimension(20, 20));
	numb.setForeground(Colors.BACK_GROUND);
	header.add(numb, c);

	c.gridx = 1;
	JLabel name = new JLabel("Card name");
	name.setHorizontalTextPosition(0);
	name.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.WHITE));
	name.setPreferredSize(new Dimension(110, 20));
	name.setForeground(Colors.BACK_GROUND);
	header.add(name, c);

	c.gridx = 2;
	JLabel info = new JLabel("Card info");
	info.setHorizontalTextPosition(0);
	info.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.WHITE));
	info.setPreferredSize(new Dimension(120, 20));
	info.setForeground(Colors.BACK_GROUND);
	header.add(info, c);

	c.gridx = 3;
	JLabel bp = new JLabel("Bid price");
	bp.setHorizontalTextPosition(0);
	bp.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.WHITE));
	bp.setPreferredSize(new Dimension(70, 20));
	bp.setForeground(Colors.BACK_GROUND);
	header.add(bp, c);

	c.gridx = 4;
	JLabel time = new JLabel("Time left");
	time.setHorizontalTextPosition(0);
	time.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.WHITE));
	time.setForeground(Colors.BACK_GROUND);
	time.setPreferredSize(new Dimension(60, 20));
	header.add(time, c);

	this.biddedItemTable = new JPanel();
	this.biddedItemTable.setBackground(Color.WHITE);

	container.add(header, "North");

	JPanel layer = new JPanel(new FlowLayout(1));
	layer.add(this.biddedItemTable);
	layer.setBackground(Color.white);
	container.add(layer, "Center");

	scrollPanel.setVerticalScrollBarPolicy(22);
	scrollPanel.setHorizontalScrollBarPolicy(31);

	return panel;
    }

    private JPanel buildTop() {
	JPanel panel = new JPanel(new BorderLayout());

	JPanel controllPanel = new JPanel(new FlowLayout(2));
	controllPanel.setPreferredSize(new Dimension(100, 0));
	controllPanel.setBackground(Colors.BACK_GROUND);

	panel.setBackground(Colors.BACK_GROUND);
	JButton logout = new JButton("Logout");
	logout.addActionListener(new LogoutActionListener());
	controllPanel.add(logout);

	JPanel infoPanel = new JPanel(new FlowLayout(0));
	infoPanel.setBackground(Colors.BACK_GROUND);

	this.applciationStatusLabel = new JLabel("Application stopped");
	this.applciationStatusLabel.setForeground(Color.RED);
	this.applciationStatusLabel.setFont(new Font("Arial", 0, 20));

	infoPanel.add(this.applciationStatusLabel);

	panel.add(controllPanel, "East");
	panel.add(infoPanel, "West");

	return panel;
    }

    public void logoutAction() {
    }

    public void refreshWatchList() {
	this.biddedItemTable.removeAll();
	this.biddedItemTable.setLayout(new GridBagLayout());
	this.biddedItemTable.setBackground(Color.WHITE);

	GridBagConstraints c = new GridBagConstraints();

	int index = 0;
	for (BiddedModelView model : this.biddedModels) {
	    c.fill = 2;
	    c.gridx = 0;
	    c.gridy = index;

	    JLabel numb = new JLabel(index + 1 + "");
	    numb.setHorizontalTextPosition(0);
	    numb.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    numb.setPreferredSize(new Dimension(20, 20));
	    this.biddedItemTable.add(numb, c);

	    c.gridx = 1;
	    JLabel name = new JLabel(model.getName());
	    name.setHorizontalTextPosition(0);
	    name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    name.setPreferredSize(new Dimension(110, 20));
	    this.biddedItemTable.add(name, c);

	    c.gridx = 2;
	    JLabel info = new JLabel(model.getInfo());
	    info.setHorizontalTextPosition(0);
	    info.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    info.setPreferredSize(new Dimension(120, 20));
	    this.biddedItemTable.add(info, c);

	    c.gridx = 3;
	    JLabel bp = new JLabel(model.getPrice());
	    bp.setHorizontalTextPosition(0);
	    bp.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    bp.setPreferredSize(new Dimension(70, 20));
	    this.biddedItemTable.add(bp, c);

	    c.gridx = 4;
	    JLabel time = new JLabel(model.getTimeLeft());
	    time.setHorizontalTextPosition(0);
	    time.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	    time.setPreferredSize(new Dimension(60, 20));
	    this.biddedItemTable.add(time, c);

	    index++;
	}
	this.biddedItemTable.updateUI();
    }

    public void clearData() {
	this.workControllButton.setText("Start");
	this.workControllButton.setEnabled(true);
	this.autobidderMode.setEnabled(true);
	this.autobuyerMode.setEnabled(true);

	this.logField.setText("");

	this.applciationStatusLabel.setText("Application stopped");

	this.currentActionLabel.setText("Stopped");
	this.currentBalanceLebel.setText("0");
	this.currentBoughtItemLabel.setText("0");
	this.currentSoldItemLabel.setText("0");
	this.currentAuctionSizeLabel.setText("0");
	doLogout = false;

	//this.biddedModels.clear();
	refreshWatchList();
    }

    @Override
    public boolean isDoLogout() {
	return doLogout;
    }

    @Override
    public void setDoLogout(boolean doLogout) {
	this.doLogout = doLogout;
    }

    @Override
    public AbstractButton getWorkControllButton() {
	return workControllButton;
    }

    @Override
    public AbstractButton getAutoBidderMode() {
	return autobidderMode;
    }

    @Override
    public AbstractButton getAutoBuyerMode() {
	return autobuyerMode;
    }

    @Override
    public boolean getDoLogout() {
	return doLogout;
    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub

    }

    @Override
    public JComponent getBidderItemPanel() {
	return biddedItemTablePanel;
    }

}
