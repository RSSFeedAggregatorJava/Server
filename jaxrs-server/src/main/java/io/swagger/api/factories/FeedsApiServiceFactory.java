package io.swagger.api.factories;

import io.swagger.api.FeedsApiService;
import io.swagger.api.impl.FeedsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public class FeedsApiServiceFactory {
    private final static FeedsApiService service = new FeedsApiServiceImpl();

    public static FeedsApiService getFeedsApi() {
        return service;
    }
}
