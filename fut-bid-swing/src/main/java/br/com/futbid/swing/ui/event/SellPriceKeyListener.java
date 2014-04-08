package br.com.futbid.swing.ui.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.springframework.stereotype.Component;

@Component
public class SellPriceKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
	// PlayerOptionPanel.this.calculateProfit();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
