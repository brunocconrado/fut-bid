package br.com.futbid.swing.ui.panel.option;

import java.util.List;

import br.com.futbid.domain.Card;

public interface CardsOption<T extends Card> {

    public List<T> getCards();
    
}
