package br.com.futbid.integration.repository.impl;

import java.sql.ResultSet;

import br.com.futbid.integration.repository.PlayerRepository;
import br.com.futbid.integration.repository.connection.SQLLiteConnection;

public class PlayerRepositoryImpl implements PlayerRepository {

    private SQLLiteConnection connection = SQLLiteConnection.getInstance();

    public void findAll() {

	try {
	    String result = "";
	    String sql = "select * from search_list where id = 1";
	    ResultSet rs = connection.getConnection().createStatement().executeQuery(sql);
	    while (rs.next()) {
		result = rs.getString("data");
	    }

	    System.out.println(result);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
