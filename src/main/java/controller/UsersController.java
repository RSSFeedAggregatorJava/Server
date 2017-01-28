package controller;


import java.sql.SQLException;

import dao.UsersDAO;
import io.swagger.model.Credentials;
import io.swagger.model.User;
import utils.BCrypt;
import utils.TokenGenerator;

public class UsersController {

	public static User signUp(Credentials credentials) throws SQLException {
		User user = new User();
		user.setApiKey(TokenGenerator.generate());
		user.setEmail(credentials.getEmail());
		user.setPassword(credentials.getPassword());

		UsersDAO.createUser(user);
		return user;
	}

	public static User login(Credentials credentials) throws SQLException {
		User newUser = new User();
		newUser.setApiKey(TokenGenerator.generate());
		newUser.setEmail(credentials.getEmail());
		newUser.setPassword(credentials.getPassword());
		User dbUser = UsersDAO.readUserByEmail(newUser.getEmail());
		if (BCrypt.checkpw(newUser.getPassword(), dbUser.getPassword())) {
			System.out.println(dbUser.getPassword());
			UsersDAO.updateToken(newUser);
			return newUser;
		}
		return null;
	}

	public static void logout(String apiKey) throws SQLException {
		UsersDAO.deleteToken(apiKey);
	}
}
