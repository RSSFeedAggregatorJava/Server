package io.swagger.api;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sun.syndication.io.FeedException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public abstract class FeedsApiService {
	public abstract Response feedsDelete(String feedId,SecurityContext securityContext,String apiKey) throws NotFoundException, SQLException;
	public abstract Response feedsFeedIdGet(Long feedId,SecurityContext securityContext,String apiKey) throws NotFoundException, SQLException;
	public abstract Response feedsGet(SecurityContext securityContext,String apiKey) throws NotFoundException, IllegalArgumentException, SQLException, FeedException, IOException;
	public abstract Response feedsPost(String feedUrl,SecurityContext securityContext,String apiKey) throws IllegalArgumentException, SQLException, FeedException, IOException;
}
