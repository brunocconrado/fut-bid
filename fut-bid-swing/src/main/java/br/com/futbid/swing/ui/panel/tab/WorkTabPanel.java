package br.com.futbid.swing.ui.panel.tab;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.work.WorkPanel;

public class WorkTabPanel extends JPanel {
    
    private static final long serialVersionUID = 2014031101L;
    
    private AuthenticationPainel authenticationPanel;
    private WorkPanel workPanel;

    public WorkTabPanel(AuthenticationPainel authenticationPanel, WorkPanel workPanel) {
	this.authenticationPanel = authenticationPanel;
	this.workPanel = workPanel;
	this.authenticationPanel.setWorkPanel(this);
	
	showAuthenticationPanel();
    }

    private void showAuthenticationPanel() {
	removeAll();
	setLayout(new BorderLayout());
	authenticationPanel.clearFields();

	add((Component) authenticationPanel, "Center");

	updateUI();
    }

    public void showAutoBuyerPanel() {
	removeAll();
	setLayout(new BorderLayout());
	
	if(getParent() instanceof JTabbedPane) {
	    JTabbedPane tabbledPane = (JTabbedPane)getParent();
	  /*  tabbledPane.remove(this);
	    tabbledPane.addTab(Tab.WORK.getName(), this);*/
	}

	workPanel.clear();
	add((Component) workPanel, "Center");

	updateUI();
    }
    
}
