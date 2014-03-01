package br.com.futbid.swing.ui.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.futbid.swing.ui.enumeration.Tab;
import br.com.futbid.swing.ui.settings.SettingsPanel;

public class ChangeTabListener implements ChangeListener {

    private Tab tab;

    public ChangeTabListener(Tab tab) {
	this.tab = tab;
    }

    @Override
    public void stateChanged(ChangeEvent event) {
	Object object = event.getSource();
	if (object instanceof SettingsPanel && ((SettingsPanel) object).getName().equals(tab.getName())) {
	    ((SettingsPanel) object).updateFields();
	}
    }

}
