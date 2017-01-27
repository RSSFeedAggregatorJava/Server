package io.swagger.api.factories;

import io.swagger.api.FeedsApiService;
import io.swagger.api.impl.FeedsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class FeedsApiServiceFactory {
    private final static FeedsApiService service = new FeedsApiServiceImpl();

    public static FeedsApiService getFeedsApi() {
        return service;
    }
}
