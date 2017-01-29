package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.NotFoundException;
import io.swagger.model.Feed;
import io.swagger.model.InlineResponse2001;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import com.sun.syndication.io.FeedException;

import controller.FeedsController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class FeedsApiServiceImpl extends FeedsApiService {
    @Override
    public Response feedsDelete(Integer feedId, SecurityContext securityContext, String apiKey) throws NotFoundException, SQLException {
        FeedsController.unsubscribeFeed(feedId, apiKey);
        return Response.ok().build();
    }
    @Override
    public Response feedsFeedIdGet(Long feedId, SecurityContext securityContext, String apiKey) throws NotFoundException, SQLException {
        Feed feed = FeedsController.getFeed(feedId, apiKey);
        return Response.ok(feed).build();
    }
    @Override
    public Response feedsGet(SecurityContext securityContext, String apiKey) throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException {
    	List<InlineResponse2001> feeds = FeedsController.getFeeds(apiKey);
        return Response.ok(feeds).build();
    }
    @Override
    public Response feedsPost(String feedUrl, SecurityContext securityContext, String apiKey) throws IllegalArgumentException, SQLException, FeedException, IOException {
        //FeedsController.subscribeFeed(feedUrl, apiKey);
        return Response.status(200).entity(apiKey).build();
    }
}
