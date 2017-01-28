package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sun.syndication.io.FeedException;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.FeedsApiServiceFactory;
import io.swagger.model.Feed;
import io.swagger.model.InlineResponse2001;

@Path("/feeds")


@io.swagger.annotations.Api(description = "the feeds API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class FeedsApi  {
   private final FeedsApiService delegate = FeedsApiServiceFactory.getFeedsApi();

    @DELETE
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Unsuscribe to a feed by url (keep it in database, juste remove reference for user)", notes = "", response = void.class, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful unsubscribed", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "feed doesn't exist", response = void.class) })
    public Response feedsDelete(@ApiParam(value = "feedId",required=true) Integer feedId
,@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
    throws NotFoundException, SQLException {
        return delegate.feedsDelete(feedId,securityContext,apiKey);
    }
    @GET
    @Path("/{feedId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find a feed and retrieve its articles", notes = "Returns id and titles of articles of this feed", response = Feed.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Feed.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Feed.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "feed not found", response = Feed.class) })
    public Response feedsFeedIdGet(@ApiParam(value = "feedId",required=true) @PathParam("feedId") Long feedId
,@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
    throws NotFoundException, SQLException {
        return delegate.feedsFeedIdGet(feedId,securityContext,apiKey);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all feeds subscribed by currend user", notes = "", response = InlineResponse2001.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "the lisT of feedS subscribed by user", response = InlineResponse2001.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid tag value", response = InlineResponse2001.class, responseContainer = "List") })
    public Response feedsGet(@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
    throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException {
        return delegate.feedsGet(securityContext,apiKey);
    }
    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Suscribe to a feed by url (add it in database, and reference its id for current user)", notes = "", response = BigDecimal.class, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BigDecimal.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "url doesn't correspond to valid rss file", response = BigDecimal.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "url inaccessible", response = BigDecimal.class) })
    public Response feedsPost(@ApiParam(value = "feedUrl",required=true) String feedUrl
,@Context SecurityContext securityContext,@HeaderParam("apiKey") String apiKey)
		throws IllegalArgumentException, SQLException, FeedException, IOException
     {
        return delegate.feedsPost(feedUrl,securityContext,apiKey);
    }
}
