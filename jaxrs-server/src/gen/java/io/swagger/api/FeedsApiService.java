package io.swagger.api;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public abstract class FeedsApiService {
    public abstract Response feedsDelete(Integer feedId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response feedsFeedIdGet(Long feedId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response feedsGet(SecurityContext securityContext) throws NotFoundException;
    public abstract Response feedsPost(String feedUrl,SecurityContext securityContext) throws NotFoundException;
}
