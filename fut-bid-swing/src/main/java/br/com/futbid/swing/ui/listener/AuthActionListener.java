package br.com.futbid.swing.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import br.com.futbid.service.AuthenticationService;
import br.com.futbid.service.impl.AuthenticationServiceImpl;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.auth.impl.AuthenticationPainelImpl;

public class AuthActionListener implements ActionListener {

    private AuthenticationService authenticationService = new AuthenticationServiceImpl();

    @Override
    public void actionPerformed(ActionEvent event) {
	Object obj = ((JButton) event.getSource()).getParent().getParent().getParent();
	if (obj instanceof AuthenticationPainel) {
	    AuthenticationPainel authenticationPainel = (AuthenticationPainelImpl) obj;
	    boolean isAuthenticated = authenticationService.login(authenticationPainel.getCredentials());
	    Object parentAuthenticationPanel = authenticationPainel.getParent();
	    if (parentAuthenticationPanel instanceof JTabbedPane) {
		for (Component component : ((JTabbedPane) parentAuthenticationPanel).getComponents()) {
		    component.setEnabled(isAuthenticated);
		    component.setVisible(isAuthenticated);
		}
	    }
	    if (isAuthenticated) {
		authenticationPainel.showAutoBuyerPanel();
	    }
	}

    }

}
