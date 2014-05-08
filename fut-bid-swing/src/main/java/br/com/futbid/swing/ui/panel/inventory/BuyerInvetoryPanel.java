package br.com.futbid.swing.ui.panel.inventory;

import java.util.List;

import br.com.futbid.domain.Card;
import br.com.futbid.swing.ui.panel.option.CardsOption;
import br.com.futbid.swing.ui.panel.option.OptionPanel;

public interface BuyerInvetoryPanel {

    public void changeOptionPanelByType(CardsOption<?> cardOption);
    
    public OptionPanel getOptionPanel();

    public void setCards(List<? extends Card> cards);

    public <T extends Card> void addCards(T card);

}
