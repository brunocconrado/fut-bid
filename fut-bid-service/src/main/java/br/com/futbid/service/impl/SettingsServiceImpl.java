package br.com.futbid.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.Settings;
import br.com.futbid.domain.enumeration.Level;
import br.com.futbid.domain.search.Type;
import br.com.futbid.integration.repository.SettingsRepository;
import br.com.futbid.integration.repository.impl.PlayerRepositoryImpl;
import br.com.futbid.service.SettingsService;

@Service
public class SettingsServiceImpl implements SettingsService {
    
    private static final Logger LOG = LoggerFactory.getLogger(SettingsServiceImpl.class);

    @Autowired
    private SettingsRepository settingsIntegration;

    @Autowired
    private PlayerRepositoryImpl playerRepository;
    
    public void save(Settings settings) {
	settingsIntegration.saveOrUpdate(settings);
    }

    public Settings find() {
	playerRepository.save(playerRepository.findAll());
	
	Settings settings = settingsIntegration.find();
	return settings == null ? new Settings() : settings;
    }

}
