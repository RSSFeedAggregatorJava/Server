package io.swagger.api;

import io.swagger.api.NotFoundException;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sun.syndication.io.FeedException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public abstract class ArticlesApiService {
    public abstract Response articlesFeedIdArticleIdGet(String feedId,String articleId,SecurityContext securityContext, String apiKey) throws IllegalArgumentException, SQLException, FeedException, IOException;
    public abstract Response articlesFeedIdGet(String feedId,SecurityContext securityContext, String apiKey) throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException;
}
