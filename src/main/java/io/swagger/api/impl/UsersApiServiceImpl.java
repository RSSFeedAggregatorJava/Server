package io.swagger.api.impl;

import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import controller.UsersController;
import io.swagger.api.NotFoundException;
import io.swagger.api.UsersApiService;
import io.swagger.model.Credentials;
import io.swagger.model.User;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class UsersApiServiceImpl extends UsersApiService {
	@Override
	public Response usersLoginPost(Credentials credentials, SecurityContext securityContext) throws NotFoundException, SQLException {
		User user = UsersController.login(credentials);
		if (user == null)
			return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
		return Response.ok(user).build();
	}
	@Override
	public Response usersLogoutGet(SecurityContext securityContext, String apiKey) throws NotFoundException, SQLException {
		UsersController.logout(apiKey);
		return Response.ok().build();
	}
	@Override
	public Response usersSignupPost(Credentials credentials, SecurityContext securityContext) throws NotFoundException, SQLException {
		User user = UsersController.signUp(credentials);
		return Response.ok(user).build();
	}
}
