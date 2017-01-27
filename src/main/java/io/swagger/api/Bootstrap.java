package io.swagger.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = -3027164743593330062L;

@Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Swagger Server")
      .description("This is an api for \"RSS Feed Aggregator\".  [View Subject](https://intra.epitech.eu/module/2016/M-EAP-650/PAR-9-1/acti-235029/project/file/RSS-feed-aggregator.pdf) or [Messenger group](https://www.messenger.com/t/552069568251252)  A successfull login or signup generate a key usable to authenticate request  This key is owned by one account, a request providing an apiKey should get result for the user owning this key. ")
      .termsOfService("")
      .contact(new Contact()
        .email(""))
      .license(new License()
        .name("")
        .url("http://unlicense.org"));

    config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
