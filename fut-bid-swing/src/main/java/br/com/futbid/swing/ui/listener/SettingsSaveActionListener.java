package br.com.futbid.swing.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.futbid.swing.ui.settings.SettingsPanel;

public class SettingsSaveActionListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent event) {
	
	Object object = ((JButton)event.getSource()).getParent().getParent();
	if(object instanceof SettingsPanel) {
	    SettingsPanel settings = (SettingsPanel) object;
	    settings.save();
	}
	
    }

}