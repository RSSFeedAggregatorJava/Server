package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			Thread.sleep(2000);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?autoReconnect=true", "root", "C5C4ng2ohfry03gG"); //C5C4ng2ohfry03gG
			Statement stt = conn.createStatement();
			stt.executeUpdate("CREATE DATABASE IF NOT EXISTS rssfeedagregator;");
			stt.executeUpdate("USE rssfeedagregator;");
			createTables();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createTables() throws SQLException {
		Statement stt = conn.createStatement();
		stt.executeUpdate("CREATE TABLE IF NOT EXISTS feeds (" +
				"id int(11) NOT NULL AUTO_INCREMENT," +
				"user_id int(11) NOT NULL," +
				"title char(128) NOT NULL," +
				"url char(128) NOT NULL," +
				"description text NOT NULL," +
				"link char(128) NOT NULL," +
				"copyright char(128)," +
				"image char(128)," +
				"language char(128)," +
				"pubDate char(128)," +
				"PRIMARY KEY (id)," +
				"UNIQUE KEY id_UNIQUE (id)," +
				"UNIQUE KEY url_UNIQUE (url)" +
				") ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;");
		stt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
				"id int(11) NOT NULL AUTO_INCREMENT," +
				"email char(32) NOT NULL," +
				"password char(64) NOT NULL," +
				"token char(32) DEFAULT NULL," +
				"PRIMARY KEY (id)," +
				"UNIQUE KEY id_UNIQUE (id)," +
				"UNIQUE KEY email_UNIQUE (email)," +
				"UNIQUE KEY password_UNIQUE (password)," +
				"UNIQUE KEY token_UNIQUE (token)" +
				") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;");
	}
}
