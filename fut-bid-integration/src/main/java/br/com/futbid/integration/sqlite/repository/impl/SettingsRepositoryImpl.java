package br.com.futbid.integration.sqlite.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import br.com.futbid.domain.Settings;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.repository.SettingsRepository;
import br.com.futbid.integration.repository.connection.SQLLiteConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Profile(value = "swing")
public class SettingsRepositoryImpl implements SettingsRepository {
    
    private static final Logger LOG = LoggerFactory.getLogger(SettingsRepositoryImpl.class);

    @Autowired
    private SQLLiteConnection connection;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public Settings find() {
	try {
	    String sql = "select * from settings where id = 1";
	    ResultSet rs = connection.getConnection().createStatement().executeQuery(sql);
	    String result = null;
	    while (rs.next()) {
		result = rs.getString("data");
	    }

	    return result == null ? null : mapper.readValue(result, Settings.class);
	} catch (Exception e) {
	    LOG.error("Error find", e);
	    throw new IntegrationException(e);
	}
    }

    @Override
    public boolean saveOrUpdate(Settings settings) {

	try {

	    String data = mapper.writeValueAsString(settings);

	    String sql = "update settings set data = '" + data + "' where id = " + "1";
	    if (!exist()) {
		sql = "insert into settings (id,data) values (1,'" + data + "')";
	    }

	    return connection.getConnection().createStatement().executeUpdate(sql) > 0;
	} catch (Exception e) {
	    LOG.error("Error saveOrUpdate", e);
	    throw new IntegrationException(e);
	}
    }

    private boolean exist() throws SQLException, ClassNotFoundException {
	String sql = "select count(*) as st from settings where id = 1";
	ResultSet rs = connection.getConnection().createStatement().executeQuery(sql);
	boolean exist = false;
	if (rs.next()) {
	    exist = rs.getBoolean("st");
	}

	return exist;
    }

}
