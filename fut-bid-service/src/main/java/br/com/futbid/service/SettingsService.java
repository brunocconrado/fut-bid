package br.com.futbid.service;

import br.com.futbid.domain.Settings;

public interface SettingsService {

    void save(Settings settings);

    Settings find();

}
