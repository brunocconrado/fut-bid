package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.futbid.service.AuthenticationService;
import br.com.futbid.service.AutoBuyerService;
import br.com.futbid.swing.ui.panel.work.WorkPanel;

public class LogoutActionListener implements ActionListener {

    private AutoBuyerService autoBuyerService;

    private AuthenticationService authenticationService;

    @Override
    public void actionPerformed(ActionEvent event) {
	if (autoBuyerService.isWork()) {
	    autoBuyerService.stop();

	    Object obj = ((JButton) event.getSource()).getParent().getParent().getParent();
	    if (obj instanceof WorkPanel) {
		WorkPanel workPanel = (WorkPanel) obj;
		workPanel.getWorkControllButton().setEnabled(false);
		workPanel.getAutoBidderMode().setEnabled(false);
		workPanel.getAutoBuyerMode().setEnabled(false);
		workPanel.setDoLogout(true);
	    }
	} else {
	    authenticationService.logout();
	}
    }
}
