package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public interface ConnectionUtils {

	static Connection getConnection() throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Connection con =null;
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(rb.getString("jndiname"));
			con = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) throws SQLException {
		getConnection();
	}
}
