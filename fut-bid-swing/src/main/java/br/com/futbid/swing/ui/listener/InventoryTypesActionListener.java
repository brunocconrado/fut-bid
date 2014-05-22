package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.enumeration.InventoryTypes;
import br.com.futbid.swing.config.Config;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;
import br.com.futbid.swing.ui.panel.option.CardsOption;

@Component
public class InventoryTypesActionListener implements ActionListener {

    private static final Logger LOG = LoggerFactory.getLogger(InventoryTypesActionListener.class);

    @PostConstruct
    public void init() {
	LOG.debug("Init class {}", this.getClass().getSimpleName());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent event) {

	try {
	    JComboBox<InventoryTypes> inventoryComBox = ((JComboBox<InventoryTypes>) event.getSource());
	    if (inventoryComBox.getParent() != null) {
		BuyerInvetoryPanel buyBuyerInvetoryPanel = (BuyerInvetoryPanel) inventoryComBox.getParent().getParent()
			.getParent();

		Class<?> clazz = Class.forName(((InventoryTypes) inventoryComBox.getSelectedItem()).getClassName());
		CardsOption<?> cardsOption = (CardsOption<?>) Config.getBean(clazz);

		buyBuyerInvetoryPanel.changeOptionPanelByType(cardsOption);
		buyBuyerInvetoryPanel.setCards(cardsOption.getCards());

	    }
	} catch (ClassNotFoundException e) {
	    LOG.error("Error try change action listener ", e);
	}
    }
}
