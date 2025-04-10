package lasalle.edu.mx.biblioteca.utils;

import org.springframework.http.HttpStatus;

public class CustomResponse {
    private HttpStatus httpCode;
    private Object data;
    private Object message;
    private int Code;

    public HttpStatus getHttpCode() {
        return httpCode;
    }
    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Object getMessage() {
        return message;
    }
    public void setMessage(Object message) {
        this.message = message;
    }
    public int getCode() {
        return Code;
    }
    public void setCode(int Code) {
        this.Code = Code;
    }
    public CustomResponse(HttpStatus httpCode, Object data, Object message, int Code) {
        this.httpCode = httpCode;
        this.data = data;
        this.message = message;
        this.Code = Code;
    }
    public CustomResponse() {}
}
