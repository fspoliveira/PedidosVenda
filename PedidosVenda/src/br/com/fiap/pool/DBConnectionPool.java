package br.com.fiap.pool;

import java.sql.*;

public interface DBConnectionPool {
	public Connection getConnection(String url, String userName, String password)
			throws SQLException;

	public boolean putConnection(Connection connection);

	public void registerConnection(Connection connection, String url,
			String userName, String password);	
	
}