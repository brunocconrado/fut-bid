package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.enumeration.InventoryTypes;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;
import br.com.futbid.swing.ui.panel.option.CardsOption;
import br.com.futbid.swing.ui.utils.Utils;

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
		CardsOption<?> cardsOption =  (CardsOption<?>) Utils.getBean(clazz);
		buyBuyerInvetoryPanel.setCards(cardsOption.getCards());
		buyBuyerInvetoryPanel.changeOptionPanelByType((JPanel) cardsOption);
	    }
	} catch (ClassNotFoundException e) {
	    LOG.error("Error try change action listener ", e);
	}

    }

}
