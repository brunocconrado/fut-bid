package br.com.futbid.swing.ui.panel.tab;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.futbid.domain.enumeration.Tab;
import br.com.futbid.swing.ui.panel.auth.AuthenticationPainel;
import br.com.futbid.swing.ui.panel.work.WorkPanel;

@org.springframework.stereotype.Component
public class WorkTabPanel extends JPanel {
    
    private static final long serialVersionUID = 2014031101L;
    
    @Autowired
    private AuthenticationPainel authenticationPanel;
    
    @Autowired
    private WorkPanel workPanel;

    @PostConstruct
    public void init() {
	showAuthenticationPanel();
    }

    private void showAuthenticationPanel() {
	removeAll();
	setLayout(new BorderLayout());
	authenticationPanel.clearFields();
	authenticationPanel.setWorkTabPanel(this);
	add((Component) authenticationPanel, "Center");

	updateUI();
    }

    public void showAutoBuyerPanel() {
	removeAll();
	updateUI();
	setLayout(new BorderLayout());
	
	if(getParent() instanceof JTabbedPane) {
	    JTabbedPane tabbledPane = (JTabbedPane)getParent();
	    tabbledPane.setTitleAt(0, Tab.WORK.getName());
	}

	workPanel.clear();
	add((Component) workPanel, "Center");
	((JPanel) workPanel).updateUI();
	
	updateUI();
    }
    
}
