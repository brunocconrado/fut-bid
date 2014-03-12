package br.com.futbid.swing.ui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.auth.impl.AuthenticationPainelImpl;

public class AuthActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
	Object obj = ((JButton)event.getSource()).getParent().getParent().getParent();
	if(obj instanceof AuthenticationPainel) {
	    AuthenticationPainel authenticationPainel = (AuthenticationPainelImpl) obj;
	    boolean isAuthenticated = authenticationPainel.login();
	    Object parentAuthenticationPanel = authenticationPainel.getParent();
	    if(parentAuthenticationPanel instanceof JTabbedPane) {
		for(Component component : ((JTabbedPane)parentAuthenticationPanel).getComponents()) {
		    component.setEnabled(isAuthenticated);
		    component.setVisible(isAuthenticated);
		}
	    }
	    if(isAuthenticated) {
		authenticationPainel.showAutoBuyerPanel();
	    }
	}
	/*if (RequestManager.INSTANCE().login(AuthenticationPanel.this.emailField.getText().trim(),
		AuthenticationPanel.this.passwordField.getText().trim(),
		AuthenticationPanel.this.answerField.getText().trim())) {
	    SessionManager.INSTANCE().setConnected(true);
	    AuthenticationPanel.this.showAudobuyerPanel();
	}*/
    }

}
