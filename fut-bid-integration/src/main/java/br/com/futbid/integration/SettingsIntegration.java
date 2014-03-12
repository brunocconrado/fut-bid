package br.com.futbid.integration;

import br.com.futbid.domain.Settings;

public interface SettingsIntegration {
    
    void save(Settings settings);
    
    Settings find();

}
