package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class ApiException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2174637728997742359L;
	public ApiException (int code, String msg) {
        super(msg);
    }
}
