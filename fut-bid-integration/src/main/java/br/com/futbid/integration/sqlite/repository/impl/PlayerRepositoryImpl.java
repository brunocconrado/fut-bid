package br.com.futbid.integration.sqlite.repository.impl;

import static java.lang.String.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import br.com.futbid.domain.Player;
import br.com.futbid.integration.repository.IdManagerRepository;
import br.com.futbid.integration.repository.PlayerRepository;
import br.com.futbid.integration.repository.connection.SQLLiteConnection;
import br.com.futbid.integration.repository.exception.RepositoryException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Profile(value = "swing")
public class PlayerRepositoryImpl implements PlayerRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PlayerRepositoryImpl.class);

    @Autowired
    private SQLLiteConnection connection;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IdManagerRepository idManager;

    @Override
    public List<Player> findAll() {

	List<Player> players = new ArrayList<>();
	try {

	    String sql = format("select id, card from cards where clazz = '%s'", Player.class.getCanonicalName());
	    ResultSet rs = connection.getConnection().createStatement().executeQuery(sql);
	    while (rs.next()) {
		String card = rs.getString("card");
		Player player = mapper.readValue(card, Player.class);
		player.setId(rs.getLong("id"));
		players.add(player);
	    }

	} catch (Exception e) {
	    LOG.error("error searchign playes", e);
	    throw new RepositoryException(e);
	}

	return players;
    }

    @Override
    public void save(List<Player> players) {
	for (Player player : players) {
	    player = saveOrUpdate(player);
	}
    }

    @Override
    public Player saveOrUpdate(Player player) {

	try {

	    boolean success = false;
	    if (player.getId() != null && exist(player.getId())) {
		success = update(player);
	    } else {
		success = save(player);
	    }

	    return success ? player : null;
	} catch (Exception e) {
	    LOG.error("error saveOrUpdate playes", e);
	    throw new RepositoryException(e);
	}

    }

    @Override
    public boolean remove(Player player) {
	try {
	    String sql = "delete cards where where id = %s";
	    return connection.getConnection().createStatement().executeUpdate(format(sql, player.getId())) > 0;
	} catch (Exception e) {
	    LOG.error("error removing playes", e);
	    throw new RepositoryException(e);
	}

    }

    private boolean save(Player player) throws JsonProcessingException, ClassNotFoundException, SQLException {
	player.setId(idManager.getId(Player.class));
	String sql = "insert into cards (id, card, clazz) values(%s, '%s', '%s')";
	String json = mapper.writeValueAsString(player);
	return connection.getConnection().createStatement()
		.executeUpdate(format(sql, player.getId(), json, Player.class.getCanonicalName())) > 0;

    }

    private boolean update(Player player) throws ClassNotFoundException, SQLException, JsonProcessingException {
	String sql = "update cards set card ='%s' where id = %s";
	String json = mapper.writeValueAsString(player);
	return connection.getConnection().createStatement().executeUpdate(format(sql, json, player.getId())) > 0;
    }

    private boolean exist(Long id) throws SQLException, ClassNotFoundException {
	String sql = "select count(*) as st from cards where id = " + id;
	ResultSet rs = connection.getConnection().createStatement().executeQuery(sql);
	boolean exist = false;
	if (rs.next()) {
	    exist = rs.getBoolean("st");
	}

	return exist;
    }

}
