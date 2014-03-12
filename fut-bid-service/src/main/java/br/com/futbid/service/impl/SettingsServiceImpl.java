package br.com.futbid.service.impl;

import br.com.futbid.domain.Settings;
import br.com.futbid.integration.SettingsIntegration;
import br.com.futbid.integration.impl.SettingsIntegrationImpl;
import br.com.futbid.service.SettingsService;

public class SettingsServiceImpl implements SettingsService {

    private SettingsIntegration settingsIntegration = new SettingsIntegrationImpl();

    public void save(Settings settings) {
	settingsIntegration.save(settings);
    }

    public Settings find() {
	Settings settings = settingsIntegration.find();
	return settings == null ? new Settings() : settings;
    }

}
