package io.swagger.api.factories;

import io.swagger.api.ArticlesApiService;
import io.swagger.api.impl.ArticlesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public class ArticlesApiServiceFactory {
    private final static ArticlesApiService service = new ArticlesApiServiceImpl();

    public static ArticlesApiService getArticlesApi() {
        return service;
    }
}
