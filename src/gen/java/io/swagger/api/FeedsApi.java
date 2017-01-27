package io.swagger.api;

import io.swagger.api.FeedsApiService;
import io.swagger.api.factories.FeedsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import io.swagger.model.Feed;
import io.swagger.model.InlineResponse2001;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

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
    public Response feedsDelete(@ApiParam(value = "ID of feed that user want to unsubscribe",required=true) @QueryParam("feedId") Integer feedId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.feedsDelete(feedId,securityContext);
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
    public Response feedsFeedIdGet(@ApiParam(value = "ID of feed that needs to be fetched",required=true) @PathParam("feedId") Long feedId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.feedsFeedIdGet(feedId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all feeds subscribed by currend user", notes = "", response = InlineResponse2001.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "api_key")
    }, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "the lisT of feedS subscribed by user", response = InlineResponse2001.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid tag value", response = InlineResponse2001.class, responseContainer = "List") })
    public Response feedsGet(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.feedsGet(securityContext);
    }
    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Suscribe to a feed by url (add it in database, and reference its id for current user)", notes = "", response = BigDecimal.class, tags={ "feed", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = BigDecimal.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "url doesn't correspond to valid rss file", response = BigDecimal.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "url inaccessible", response = BigDecimal.class) })
    public Response feedsPost(@ApiParam(value = "url of feed that user want to subscribe",required=true) @QueryParam("feedUrl") String feedUrl
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.feedsPost(feedUrl,securityContext);
    }
}
