package br.com.futbid.integration.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "swing")
public class SQLLiteConnection {

    private static final Logger LOG = LoggerFactory.getLogger(SQLLiteConnection.class);

    private Connection conn;

    public SQLLiteConnection() {
    }

    @PostConstruct
    public void init() {
	try {
	    createConnection();
	    createTables();
	    LOG.info("Opened database successfully");
	} catch (Exception e) {
	    LOG.error("Error trying configurate db", e);
	}
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
	if (conn.isClosed()) {
	    createConnection();
	}
	return conn;
    }

    private void createTables() throws SQLException {
	String sql = "create table if not exists settings (id INTEGER PRIMARY KEY,data TEXT);";
	conn.createStatement().execute(sql);

	sql = "create table if not exists license (id INTEGER PRIMARY KEY,email TEXT,license TEXT);";
	conn.createStatement().execute(sql);

	sql = "create table if not exists id_manager (clazz TEXT PRIMARY KEY, id LONG);";
	conn.createStatement().execute(sql);

	sql = "create table if not exists cards (id LONG PRIMARY KEY, clazz TEXT, card TEXT);";
	conn.createStatement().execute(sql);
    }

    private void createConnection() throws ClassNotFoundException, SQLException {
	Class.forName("org.sqlite.JDBC");
	conn = DriverManager.getConnection("jdbc:sqlite:fut-bid-db.db");
	conn.setAutoCommit(true);
    }

    /*
     * public String loadAutobuyerSearchList() throws SQLException { String result = ""; String sql =
     * "select * from search_list where id = 1"; ResultSet rs = this.dbStatement.executeQuery(sql); while (rs.next()) {
     * result = rs.getString("data"); } return result; }
     * 
     * private int insertAutobuyerSearchList(String data) throws SQLException { String sql =
     * "insert into search_list (id,data) values (1,'" + data + "')";
     * 
     * return this.dbStatement.executeUpdate(sql); }
     * 
     * public int saveAutobuyerSearchList(String string) throws SQLException { String sql =
     * "update search_list set data = '" + string + "' where id = " + "1";
     * 
     * int saveResult = this.dbStatement.executeUpdate(sql); if (saveResult <= 0) { return
     * insertAutobuyerSearchList(string); } return saveResult; }
     * 
     * public String loadAutobidderSearchList() throws SQLException { String result = ""; String sql =
     * "select * from search_list where id = 2"; ResultSet rs = this.dbStatement.executeQuery(sql); while (rs.next()) {
     * result = rs.getString("data"); } return result; }
     * 
     * private int insertAutobidderSearchList(String data) throws SQLException { String sql =
     * "insert into search_list (id,data) values (2,'" + data + "')";
     * 
     * return this.dbStatement.executeUpdate(sql); }
     * 
     * public int saveAutobidderSearchList(String string) throws SQLException { String sql =
     * "update search_list set data = '" + string + "' where id = " + "2";
     * 
     * int saveResult = this.dbStatement.executeUpdate(sql); if (saveResult <= 0) { return
     * insertAutobidderSearchList(string); } return saveResult; }
     * 
     * }
     */

}
