package br.com.futbid.integration.repository;

import java.util.List;

import br.com.futbid.domain.Player;

public interface PlayerRepository {

    Player saveOrUpdate(Player player);

    void save(List<Player> players);

    List<Player> findAll();

    boolean remove(Player player);

}
