package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.NotFoundException;
import io.swagger.model.Article;
import io.swagger.model.InlineResponse2001;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sun.syndication.io.FeedException;

import controller.ArticlesController;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class ArticlesApiServiceImpl extends ArticlesApiService {
    @Override
    public Response articlesFeedIdArticleIdGet(String feedId, String articleId, SecurityContext securityContext, String apiKey) throws IllegalArgumentException, SQLException, FeedException, IOException {
        Article article = ArticlesController.getArticle(feedId, articleId);
        return Response.ok(article).build();
    }
    @Override
    public Response articlesFeedIdGet(String feedId, SecurityContext securityContext, String apiKey) throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException {
    	List<InlineResponse2001> articles = ArticlesController.getArticles(feedId, apiKey);
        return Response.ok(articles).build();
    }
}
