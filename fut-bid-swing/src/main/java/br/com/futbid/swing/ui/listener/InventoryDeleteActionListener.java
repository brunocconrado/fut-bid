package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.futbid.domain.Card;
import br.com.futbid.domain.Player;
import br.com.futbid.service.PlayerService;
import br.com.futbid.swing.config.Config;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;

public class InventoryDeleteActionListener implements ActionListener {

    private static final Logger LOG = LoggerFactory.getLogger(InventoryDeleteActionListener.class);

    private Card card;

    private BuyerInvetoryPanel buyerInvetoryPanel;

    public InventoryDeleteActionListener(Card card, BuyerInvetoryPanel buyerInvetoryPanel) {
	this.card = card;
	this.buyerInvetoryPanel = buyerInvetoryPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	LOG.info("Removing card {}", card);

	PlayerService playerService = Config.getBean(PlayerService.class);
	if (playerService.remove((Player) card)) {
	    LOG.warn("Card removed with succes: {}", card);
	    buyerInvetoryPanel.setCards(playerService.findAll());
	    buyerInvetoryPanel.getOptionPanel().setCardSelected(new Player());
	} else {
	    LOG.warn("Card not removed: {}", card);
	}

    }

}
