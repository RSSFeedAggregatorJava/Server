package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.swagger.model.User;
import utils.BCrypt;
import utils.DBConnect;

public class UsersDAO {

	public static void createUser(User user) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("INSERT INTO users SET email = ?, password = ?, token = ?");
		stt.setString(1, user.getEmail());
		stt.setString(2, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		stt.setString(3, user.getApiKey());
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}
	
	public static User readUserByEmail(String email) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT * FROM users WHERE email = ?");
		stt.setString(1, email);
		ResultSet rs = stt.executeQuery();
		
		User user = new User();
		rs.next();
		user.setUserId(rs.getInt("id"));
		user.setApiKey(rs.getString("token"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		//TODO: Gestion erreur
		stt.close();
		return user;
	}
	
	public static User readUserByApiKey(String apiKey) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT * FROM users WHERE token = ?");
		stt.setString(1, apiKey);
		ResultSet rs = stt.executeQuery();
		if (rs.isLast())
			return null;
		User user = new User();
		rs.next();
		user.setUserId(rs.getInt("id"));
		user.setApiKey(rs.getString("token"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		//TODO: Gestion erreur
		stt.close();
		return user;
	}

	public static void updateToken(User user) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("UPDATE users SET token = ? WHERE email = ?");
		stt.setString(1, user.getApiKey());
		stt.setString(2, user.getEmail());
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}

	public static void deleteToken(String apiKey) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("UPDATE users SET token = '' WHERE token = ?");
		stt.setString(1, apiKey);
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}
}
