package br.com.futbid.swing.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.futbid.integration.impl.Session;
import br.com.futbid.integration.impl.SessionManager;
import br.com.futbid.service.AuthenticationService;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.auth.impl.AuthenticationPainelImpl;

@org.springframework.stereotype.Component
public class AuthActionListener implements ActionListener {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SessionManager sessionManager;
    
    @Override
    public void actionPerformed(ActionEvent event) {
	Object obj = ((JButton) event.getSource()).getParent().getParent().getParent();
	if (obj instanceof AuthenticationPainel) {
	    AuthenticationPainel authenticationPainel = (AuthenticationPainelImpl) obj;
	    Session session = authenticationService.login(authenticationPainel.getCredentials());
	    boolean isAuthenticated = session != null;
	    Object parentAuthenticationPanel = authenticationPainel.getParent();
	    if (parentAuthenticationPanel instanceof JTabbedPane) {
		for (Component component : ((JTabbedPane) parentAuthenticationPanel).getComponents()) {
		    component.setEnabled(isAuthenticated);
		    component.setVisible(isAuthenticated);
		}
	    }
	    if (isAuthenticated) {
		authenticationPainel.showAutoBuyerPanel();
		session.copyTo(sessionManager);
	    }
	}

    }

}
