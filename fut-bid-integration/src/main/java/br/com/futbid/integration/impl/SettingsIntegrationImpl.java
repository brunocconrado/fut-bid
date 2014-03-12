package br.com.futbid.integration.impl;

import br.com.futbid.domain.Settings;
import br.com.futbid.integration.SettingsIntegration;

public class SettingsIntegrationImpl implements SettingsIntegration {

    public void save(Settings settings) {
	//TODO
	System.out.println(settings);
    }
    
    public Settings find() {
	//FIXME
	return new Settings();
    }

}
