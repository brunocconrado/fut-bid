package br.com.futbid.swing.ui.panel.inventory;

import java.util.List;

import javax.swing.JPanel;

import br.com.futbid.domain.Card;

public interface BuyerInvetoryPanel {

    public void changeOptionPanelByType(JPanel panel);

    public void setCards(List<? extends Card> cards);
    
    public <T extends Card> void addCards(T card);

}
