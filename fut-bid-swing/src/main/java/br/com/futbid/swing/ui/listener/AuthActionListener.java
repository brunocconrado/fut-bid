package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
	event.getSource();
	/*if (RequestManager.INSTANCE().login(AuthenticationPanel.this.emailField.getText().trim(),
		AuthenticationPanel.this.passwordField.getText().trim(),
		AuthenticationPanel.this.answerField.getText().trim())) {
	    SessionManager.INSTANCE().setConnected(true);
	    AuthenticationPanel.this.showAudobuyerPanel();
	}*/
    }

}
