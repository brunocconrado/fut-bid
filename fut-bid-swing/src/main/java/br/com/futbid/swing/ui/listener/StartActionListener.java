package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.futbid.service.AutoBuyerService;
import br.com.futbid.swing.ui.panel.work.WorkPanel;

public class StartActionListener implements ActionListener {

    private AutoBuyerService autoBuyerService;

    @Override
    public void actionPerformed(ActionEvent event) {
	Object obj = ((JButton) event.getSource()).getParent().getParent();
	if (obj instanceof WorkPanel) {
	    WorkPanel workPanel = (WorkPanel) obj;
	    workPanel.getWorkControllButton().setEnabled(false);
	    workPanel.getAutoBidderMode().setEnabled(false);
	    workPanel.getAutoBuyerMode().setEnabled(false);
	    if (autoBuyerService.isWork()) {
		autoBuyerService.stop();
	    } else {
		autoBuyerService.start();
	    }

	}
    }

}
