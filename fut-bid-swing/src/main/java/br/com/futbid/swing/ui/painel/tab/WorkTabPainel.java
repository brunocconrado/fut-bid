package br.com.futbid.swing.ui.painel.tab;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import br.com.futbid.swing.ui.painel.auth.AuthenticationPainel;

public class WorkTabPainel extends JPanel {

    
    private static final long serialVersionUID = 1L;
    private AuthenticationPainel authenticationPanel;
    //private AutobuyerPanel autobuyerPanel;

    public WorkTabPainel() {
	/*this.authenticationPanel = new AuthenticationPanel() {
	    private static final long serialVersionUID = 1L;

	    public void showAudobuyerPanel() {
		BasePanel.this.showAutobuyerPanel();
	    }
	};
	this.autobuyerPanel = new AutobuyerPanel() {
	    private static final long serialVersionUID = 1L;

	    public void logoutAction() {
		SessionManager.INSTANCE().disconnect();
		BasePanel.this.showAuthenticationPanel();
	    }
	};*/
	showAuthenticationPanel();
    }

    private void showAuthenticationPanel() {
	removeAll();
	setLayout(new BorderLayout());
	this.authenticationPanel.clearData();

	add(this.authenticationPanel, "Center");

	updateUI();
    }

    private void showAutobuyerPanel() {
	removeAll();
	setLayout(new BorderLayout());

	//this.autobuyerPanel.clearData();

	//add(this.autobuyerPanel, "Center");

	updateUI();
    }
    
}
