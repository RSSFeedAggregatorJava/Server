package io.swagger.api.factories;

import io.swagger.api.ArticlesApiService;
import io.swagger.api.impl.ArticlesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class ArticlesApiServiceFactory {
    private final static ArticlesApiService service = new ArticlesApiServiceImpl();

    public static ArticlesApiService getArticlesApi() {
        return service;
    }
}
