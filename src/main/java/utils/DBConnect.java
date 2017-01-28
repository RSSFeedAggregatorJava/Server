package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConnect implements ServletContextListener{

	public static Connection conn;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			DBConnect.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rssfeedagregator", "root", "yLbS3lyy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
