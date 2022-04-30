package com.steve.boot.launch.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)){
            if(body instanceof AjaxReponse){
                int code = ((AjaxReponse)body).getCode();
                if (code == 999) {
                    response.setStatusCode(HttpStatus.valueOf(500));
                } else {
                    response.setStatusCode(HttpStatus.valueOf(code));
                }
                return body;
            }else {
                return AjaxReponse.success(body);
            }
        }

        return body;
    }
}
