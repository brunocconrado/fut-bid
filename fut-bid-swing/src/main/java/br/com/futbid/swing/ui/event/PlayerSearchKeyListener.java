package br.com.futbid.swing.ui.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Player;
import br.com.futbid.integration.SearchIntegration;
import br.com.futbid.swing.ui.panel.option.Dialog;

@Component
public class PlayerSearchKeyListener implements KeyListener {

    @Autowired
    private SearchIntegration searchIntegration;

    @Override
    public void keyTyped(KeyEvent event) {
	// no-op
    }

    @Override
    public void keyPressed(KeyEvent event) {
	// no-op
    }

    @Override
    public void keyReleased(KeyEvent event) {

	JTextField textField = (JTextField) event.getSource();

	String playerName = textField.getText();
	if (playerName.length() >= 3) {
	    List<Player> players = searchIntegration.searchPlayerByName(playerName);
	    ((Dialog) textField.getParent().getParent().getParent().getParent().getParent()).updateTable(players);
	}
    }

}
