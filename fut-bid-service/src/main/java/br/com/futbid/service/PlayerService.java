package br.com.futbid.service;

import java.util.List;

import br.com.futbid.domain.Player;

public interface PlayerService {

    public void savePlayer(Player player);

    public List<Player> findAll();

    public boolean remove(Player player);
    
}
