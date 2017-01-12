package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public class ArticlesApiServiceImpl extends ArticlesApiService {
    @Override
    public Response articlesFeedIdArticleIdGet(String feedId, String articleId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
