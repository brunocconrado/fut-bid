package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import br.com.futbid.domain.Player;
import br.com.futbid.swing.ui.panel.option.OptionPanel;

public class AddPlayerActionListener implements ActionListener {

    private Player player;

    private OptionPanel optionPanel;
    
    public AddPlayerActionListener(Player player, OptionPanel optionPanel) {
	this.player = player;
	this.optionPanel = optionPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
	optionPanel.setCardSelected(player);
	((JDialog)optionPanel).setVisible(false);
    }

}
 