package io.swagger.api;

import io.swagger.model.Credentials;
import io.swagger.model.Credentials1;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public abstract class UsersApiService {
    public abstract Response usersLoginPost(Credentials1 credentials,SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersLogoutGet(SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersSignupPost(Credentials credentials,SecurityContext securityContext) throws NotFoundException;
}
