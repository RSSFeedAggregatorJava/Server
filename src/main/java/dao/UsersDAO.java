package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.swagger.model.Credentials;
import io.swagger.model.InlineResponse200;
import io.swagger.model.User;
import utils.BCrypt;
import utils.DBConnect;

public class UsersDAO {

	public static InlineResponse200 createUser(Credentials credentials, String token) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("INSERT INTO users SET email = ?, password = ?, token = ?");
		stt.setString(1, credentials.getEmail());
		stt.setString(2, BCrypt.hashpw(credentials.getPassword(), BCrypt.gensalt(12)));
		stt.setString(3, token);
		stt.executeUpdate();

		stt = DBConnect.conn.prepareStatement("SELECT id FROM users WHERE token = ?");
		stt.setString(1, token);
		ResultSet rs = stt.executeQuery();
		rs.next();
		InlineResponse200 response = new InlineResponse200();
		response.setApiKey(token);
		response.setUserId(rs.getInt("id"));
		stt.close();
		return response;
	}

	public static User readUserByEmail(String email) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT * FROM users WHERE email = ?");
		stt.setString(1, email);
		ResultSet rs = stt.executeQuery();

		User user = new User();
		rs.next();
		user.setUserId(rs.getInt("id"));
		user.setApi_key(rs.getString("token"));
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
		user.setApi_key(rs.getString("token"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		//TODO: Gestion erreur
		stt.close();
		return user;
	}

	public static InlineResponse200 updateToken(String token, String email) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("UPDATE users SET token = ? WHERE email = ?");
		stt.setString(1, token);
		stt.setString(2, email);
		stt.executeUpdate();

		//TODO: Gestion erreur
		stt = DBConnect.conn.prepareStatement("SELECT id FROM users WHERE token = ?");
		stt.setString(1, token);
		ResultSet rs = stt.executeQuery();
		rs.next();
		InlineResponse200 response = new InlineResponse200();
		response.setApiKey(token);
		response.setUserId(rs.getInt("id"));
		stt.close();
		return response;
	}

	public static void deleteToken(String apiKey) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("UPDATE users SET token = '' WHERE token = ?");
		stt.setString(1, apiKey);
		int rs = stt.executeUpdate();
		stt.close();
		//TODO: Gestion erreur
	}
}
