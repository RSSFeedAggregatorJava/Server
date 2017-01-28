package io.swagger.api;

import io.swagger.model.Credentials;
import io.swagger.api.NotFoundException;

import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public abstract class UsersApiService {
    public abstract Response usersLoginPost(Credentials credentials,SecurityContext securityContext) throws NotFoundException, SQLException;
    public abstract Response usersLogoutGet(SecurityContext securityContext, String apiKey) throws NotFoundException, SQLException;
    public abstract Response usersSignupPost(Credentials credentials,SecurityContext securityContext) throws NotFoundException, SQLException;
}
