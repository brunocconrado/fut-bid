package br.com.futbid.service.impl;

import br.com.futbid.domain.Settings;
import br.com.futbid.integration.repository.SettingsRepository;
import br.com.futbid.integration.repository.impl.PlayerRepositoryImpl;
import br.com.futbid.integration.repository.impl.SettingsRepositoryImpl;
import br.com.futbid.service.SettingsService;

public class SettingsServiceImpl implements SettingsService {

    private SettingsRepository settingsIntegration = new SettingsRepositoryImpl();

    
    private PlayerRepositoryImpl player = new PlayerRepositoryImpl();
    
    public void save(Settings settings) {
	settingsIntegration.saveOrUpdate(settings);
    }

    public Settings find() {
	player.findAll();
	
	Settings settings = settingsIntegration.find();
	return settings == null ? new Settings() : settings;
    }

}
