package br.com.futbid.integration.repository;

import br.com.futbid.domain.Settings;

public interface SettingsRepository {

    public Settings find();

    public boolean saveOrUpdate(Settings settings);

}
