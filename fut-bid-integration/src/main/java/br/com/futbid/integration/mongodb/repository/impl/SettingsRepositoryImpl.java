package br.com.futbid.integration.mongodb.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import br.com.futbid.domain.Settings;
import br.com.futbid.integration.repository.SettingsRepository;

@Repository
@Profile(value = "web")
public class SettingsRepositoryImpl implements SettingsRepository {

    private static final Logger LOG = LoggerFactory.getLogger(SettingsRepositoryImpl.class);

    @Override
    public Settings find() {
	LOG.debug("calling find {}", this.getClass().getCanonicalName());
	return null;
    }

    @Override
    public boolean saveOrUpdate(Settings settings) {
	LOG.debug("calling saveOrUpdate {}", this.getClass().getCanonicalName());
	return false;
    }

}
