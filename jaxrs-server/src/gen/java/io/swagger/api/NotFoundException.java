package io.swagger.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-10T14:57:08.577Z")
public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8000903005649088467L;
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}