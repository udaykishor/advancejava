package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface ConnectionUtils {
	static Connection  getConnection() throws SQLException, ClassNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		//com.mysql.jdbc.Driver;
		//oracle.jdbc.driver.OracleDriver;
		Class.forName(rb.getString("drivername"));
		Connection con = null;
	/*try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(rb.getString("jndiname"));
			con = ds.getConnection();
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
		System.out.println("Driver Loaded");*/
		con = DriverManager.getConnection(rb.getString("dburl"), rb.getString("userid"), rb.getString("password"));
		if(con!=null) {
			System.out.println("Connection Create");
			con.close();
		}
		return con;
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		getConnection();
	}
		
}
