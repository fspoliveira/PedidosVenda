package br.com.fiap.aspectj;

import java.sql.*;

import br.com.fiap.pool.DBConnectionPool;
import br.com.fiap.pool.SimpleDBConnectionPool;

/*4. Desenvolver um 'connection pooling' através do uso de
 Aspectos
 */

public aspect DBConnectionPoolingAspect {

	DBConnectionPool _connPool = new SimpleDBConnectionPool();

	pointcut connectionCreation(String url, String username, String password)
	: call(public static Connection
			DriverManager.getConnection(String, String, String))
			&& args(url, username, password);

	pointcut connectionRelease(Connection connection)
	: call(public void Connection.close())
	&& target(connection);

	Connection around(String url, String userName, String password)
			throws SQLException
			: connectionCreation(url, userName, password) {
		Connection connection = _connPool
				.getConnection(url, userName, password);
		if (connection == null) {
			connection = proceed(url, userName, password);
			_connPool.registerConnection(connection, url, userName, password);
		}
		return connection;
	}

	void around(Connection connection)
			: connectionRelease(connection) {
		if (!_connPool.putConnection(connection)) {
			proceed(connection);
		}
	}
}