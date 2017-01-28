package io.swagger.api;

import io.swagger.api.ArticlesApiService;
import io.swagger.api.factories.ArticlesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Article;
import io.swagger.model.InlineResponse2002;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sun.syndication.io.FeedException;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.*;

@Path("/articles")


@io.swagger.annotations.Api(description = "the articles API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
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
    public Response articlesFeedIdArticleIdGet(@ApiParam(value = "feedId",required=true) @PathParam("feedId") String feedId
,@ApiParam(value = "articleId",required=true) String articleId
,@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
    throws NotFoundException {
        return delegate.articlesFeedIdArticleIdGet(feedId,articleId,securityContext, apiKey);
    }
    @GET
    @Path("/{feedId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "retrieve the lisT of articles in the feed", notes = "", response = InlineResponse2002.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "article", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "list of articles in the feed", response = InlineResponse2002.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Order", response = InlineResponse2002.class, responseContainer = "List") })
    public Response articlesFeedIdGet(@ApiParam(value = "feedId",required=true) String feedId
,@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
    throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException {
        return delegate.articlesFeedIdGet(feedId,securityContext, apiKey);
    }
}
