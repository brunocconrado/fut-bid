package br.com.futbid.integration.repository.impl;

import static java.lang.String.format;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.futbid.integration.repository.IdManagerRepository;
import br.com.futbid.integration.repository.connection.SQLLiteConnection;
import br.com.futbid.integration.repository.exception.RepositoryException;

@Repository
public class IdManagerImplRepository implements IdManagerRepository {

    private static final Logger LOG = LoggerFactory.getLogger(IdManagerImplRepository.class);

    @Autowired
    private SQLLiteConnection connection;

    @Override
    public Long getId(Class<?> clazz) {

	try {
	    ResultSet rs = connection.getConnection().createStatement()
		    .executeQuery(format("select id from id_manager where clazz = '%s'", clazz.getCanonicalName()));

	    String sql = "update id_manager set id = %s where clazz = '%s'";

	    AtomicLong id = new AtomicLong();
	    if (rs.next()) {
		id = new AtomicLong(rs.getLong("id"));
	    } else {
		sql = "insert into id_manager (id, clazz) values(%s, '%s')";
	    }

	    if (connection.getConnection().createStatement()
		    .executeUpdate(format(sql, id.incrementAndGet(), clazz.getCanonicalName())) == 0) {
		throw new RepositoryException("Impossible to update id");
	    }

	    return id.get();
	} catch (ClassNotFoundException | SQLException e) {
	    LOG.error("Occurred a error trying getId", e);
	    throw new RepositoryException(e);
	}

    }

}
