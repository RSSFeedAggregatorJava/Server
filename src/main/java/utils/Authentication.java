package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

	public static boolean authenticate(String api_key) throws SQLException {
		PreparedStatement stt = DBConnect.conn.prepareStatement("SELECT id FROM users WHERE token = ?");
		stt.setString(1, api_key);
		ResultSet rs = stt.executeQuery();
		if (rs.isLast())
			return false;
		stt.close();
		return true;
	}
}
