package io.swagger.api;

import io.swagger.api.ArticlesApiService;
import io.swagger.api.factories.ArticlesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Article;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/articles")


@io.swagger.annotations.Api(description = "the articles API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public class ArticlesApi  {
   private final ArticlesApiService delegate = ArticlesApiServiceFactory.getArticlesApi();

    @GET
    @Path("/{feedId}/{articleId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "retrieve article feed id and article id (id correspond to 1st, 2nd, 3rd, 4th... article)", notes = "", response = Article.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "article", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Article.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Order", response = Article.class) })
    public Response articlesFeedIdArticleIdGet(@ApiParam(value = "ID of feed containing article",required=true) @PathParam("feedId") String feedId
,@ApiParam(value = "ID of article to retrieve",required=true) @PathParam("articleId") String articleId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.articlesFeedIdArticleIdGet(feedId,articleId,securityContext);
    }
}
