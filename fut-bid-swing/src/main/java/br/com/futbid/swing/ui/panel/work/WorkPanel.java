package br.com.futbid.swing.ui.panel.work;

import javax.swing.AbstractButton;
import javax.swing.JComponent;


public interface WorkPanel {

    AbstractButton getWorkControllButton();

    AbstractButton getAutoBidderMode();

    AbstractButton getAutoBuyerMode();

    void setDoLogout(boolean isDoLogout);
    
    boolean getDoLogout();

    boolean isDoLogout();
    
    void clear();

    JComponent getBidderItemPanel();
  
}
