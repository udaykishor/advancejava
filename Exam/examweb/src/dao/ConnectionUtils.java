package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public interface ConnectionUtils {
	public static Connection getConnection() throws NamingException, SQLException {
		String jndiname="java:/comp/env/jdbc/examjndi";
		Context context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup(jndiname);
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
