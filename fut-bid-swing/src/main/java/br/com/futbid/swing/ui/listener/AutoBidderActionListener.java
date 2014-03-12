package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.futbid.swing.ui.panel.work.WorkPanel;

public class AutoBidderActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
	Object obj = ((JButton) event.getSource()).getParent().getParent().getParent();
	if (obj instanceof WorkPanel) {
	    WorkPanel workPanel = (WorkPanel) obj;
	    workPanel.getBidderItemPanel().setVisible(true);
	    workPanel.getAutoBuyerMode().setSelected(false);
	    workPanel.getAutoBidderMode().setSelected(true);
	    //SessionManager.INSTANCE().setApplicationMode(SessionManager.ApplicationMode.AUTOBIDDED);
	}
    }

}
