package br.com.futbid.swing.ui.panel.option;

import java.util.List;

import javax.swing.JDialog;

import br.com.futbid.domain.Player;

public interface Dialog {

    public JDialog getDialog();
    
    public void updateTable(List<Player> players);

    public void setParent(Dialog parent);
    
}
