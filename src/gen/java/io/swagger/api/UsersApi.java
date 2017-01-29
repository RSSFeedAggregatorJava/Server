package io.swagger.api;

import io.swagger.api.UsersApiService;
import io.swagger.api.factories.UsersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Credentials;
import io.swagger.model.InlineResponse200;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.sql.SQLException;

import javax.ws.rs.*;

@Path("/users")


@io.swagger.annotations.Api(description = "the users API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class UsersApi  {
	private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

	@POST
	@Path("/login")

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Login with email and password", notes = "", response = InlineResponse200.class, tags={ "user", })
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful login", response = InlineResponse200.class),

			@io.swagger.annotations.ApiResponse(code = 401, message = "Invalid credentials", response = InlineResponse200.class) })
	public Response usersLoginPost(@ApiParam(value = "credentials" ,required=true) Credentials credentials
			,@Context SecurityContext securityContext)
					throws NotFoundException, SQLException {
		return delegate.usersLoginPost(credentials,securityContext);
	}
	@GET
	@Path("/logout")

	@Produces({ "application/json", "application/xml" })
	@io.swagger.annotations.ApiOperation(value = "Logs out current logged in user session", notes = "", response = void.class, tags={ "user", })
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = void.class) })
	public Response usersLogoutGet(@Context SecurityContext securityContext,@HeaderParam("api_key") String apiKey)
			throws NotFoundException, SQLException {
		return delegate.usersLogoutGet(securityContext,apiKey);
	}
	@POST
	@Path("/signup")

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "Signup with email and password - application/json", notes = "", response = InlineResponse200.class, tags={ "user", })
	@io.swagger.annotations.ApiResponses(value = { 
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful signup", response = InlineResponse200.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Invalid email or password", response = InlineResponse200.class) })
	public Response usersSignupPost(@ApiParam(value = "credentials" ,required=true) Credentials credentials
			,@Context SecurityContext securityContext)
					throws NotFoundException, SQLException {
		return delegate.usersSignupPost(credentials,securityContext);
	}
}
