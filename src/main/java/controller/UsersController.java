package controller;


import java.sql.SQLException;

import dao.UsersDAO;
import io.swagger.model.Credentials;
import io.swagger.model.InlineResponse200;
import io.swagger.model.User;
import utils.BCrypt;
import utils.TokenGenerator;

public class UsersController {

	public static InlineResponse200 signUp(Credentials credentials) throws SQLException {
		return UsersDAO.createUser(credentials, TokenGenerator.generate());
	}

	public static InlineResponse200 login(Credentials credentials) throws SQLException {
		User dbUser = UsersDAO.readUserByEmail(credentials.getEmail());
		if (BCrypt.checkpw(credentials.getPassword(), dbUser.getPassword())) {
			InlineResponse200 response = UsersDAO.updateToken(TokenGenerator.generate(), credentials.getEmail());
			return response;
		}
		return null;
	}

	public static void logout(String apiKey) throws SQLException {
		UsersDAO.deleteToken(apiKey);
	}
}
