package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.service.PlayerService;
import br.com.futbid.swing.ui.panel.inventory.BuyerInvetoryPanel;
import br.com.futbid.swing.ui.panel.option.OptionPanel;

@Component
public class SavePlayerActionListener implements ActionListener {

    @Autowired
    private PlayerService playerService;

    @Override
    public void actionPerformed(ActionEvent event) {
	JButton button = (JButton) event.getSource();
	OptionPanel optionPanel = (OptionPanel) button.getParent().getParent();
	playerService.savePlayer(optionPanel.getPlayerSelected());

	((BuyerInvetoryPanel) button.getParent().getParent().getParent().getParent()).addCards(optionPanel
		.getPlayerSelected());

    }

}
