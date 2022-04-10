package com.steve.boot.lauch;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder(value = {"ok","code"})
public class AjaxReponse {
    private boolean ok;
    private int code ; //"200|400|500"
    private String message;
    private Object data;

    public static AjaxReponse success(Object data){
        return AjaxReponse.builder()
                .ok(true)
                .code(200)
                .message("request successfully!")
                .data(data)
                .build();

    }
    public static AjaxReponse success(){
        return AjaxReponse.builder()
                .ok(true)
                .code(200)
                .message("request successfully!")
                .build();
    }

    public static AjaxReponse success(Object data, String message){
        return AjaxReponse.builder()
                .ok(true)
                .code(200)
                .message(message)
                .data(data)
                .build();

    }
}
