package io.swagger.api;

import io.swagger.model.Credentials;
import io.swagger.model.Credentials1;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public abstract class UsersApiService {
    public abstract Response usersLoginPost(Credentials credentials,SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersLogoutGet(SecurityContext securityContext) throws NotFoundException;
    public abstract Response usersSignupPost(Credentials1 credentials,SecurityContext securityContext) throws NotFoundException;
}
