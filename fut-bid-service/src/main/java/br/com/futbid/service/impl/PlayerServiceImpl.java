package br.com.futbid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Player;
import br.com.futbid.integration.repository.PlayerRepository;
import br.com.futbid.service.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void savePlayer(Player player) {
	playerRepository.saveOrUpdate(player);
    }

    @Override
    public List<Player> findAll() {
	return playerRepository.findAll();
    }

    @Override
    public boolean remove(Player player) {
	return playerRepository.remove(player);
    }
}
