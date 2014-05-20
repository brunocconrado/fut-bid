package br.com.futbid.integration.mongodb.repository.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import br.com.futbid.domain.Player;
import br.com.futbid.integration.repository.PlayerRepository;

@Repository
@Profile(value = "web")
public class PlayerRepositoryImpl implements PlayerRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerRepositoryImpl.class);
    
    @PostConstruct
    public void init() {
	LOG.debug("Init {}", this.getClass().getCanonicalName());
    }
    
    @Override
    public Player saveOrUpdate(Player player) {
	LOG.debug("calling saveOrupdate: {}", this.getClass().getCanonicalName());
	return null;
    }

    @Override
    public void save(List<Player> players) {
	LOG.debug("calling save: {}", this.getClass().getCanonicalName());
    }

    @Override
    public List<Player> findAll() {
	LOG.debug("calling findAll: {}", this.getClass().getCanonicalName());
	return null;
    }

    @Override
    public boolean remove(Player player) {
	LOG.debug("calling remove: {}", this.getClass().getCanonicalName());
	return false;
    }

}
