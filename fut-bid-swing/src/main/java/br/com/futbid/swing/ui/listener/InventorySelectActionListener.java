package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.futbid.domain.Card;
import br.com.futbid.swing.ui.panel.option.OptionPanel;

public class InventorySelectActionListener implements ActionListener {

    private static final Logger LOG = LoggerFactory.getLogger(InventorySelectActionListener.class);

    private Card card;

    private OptionPanel optionPanel;

    public InventorySelectActionListener(Card card, OptionPanel optionPanel) {
	this.card = card;
	this.optionPanel = optionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
	LOG.info("Selected card {}", card);
	optionPanel.setCardSelected(card);
    }

}
