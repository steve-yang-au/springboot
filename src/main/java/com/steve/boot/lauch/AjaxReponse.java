package com.steve.boot.lauch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AjaxReponse {
    private boolean isOk;
    private int code ; //"200|400|500"
    private String message;
    private Object data;

    public static AjaxReponse success(Object data){
        AjaxReponse ajaxReponse = AjaxReponse.builder()
                .isOk(true)
                .code(200)
                .message("request successfully!")
                .data(data)
                .build();
        return ajaxReponse;
    }
    public static AjaxReponse success(){
        AjaxReponse ajaxReponse = AjaxReponse.builder()
                .isOk(true)
                .code(200)
                .message("request successfully!")
                .build();
        return ajaxReponse;
    }

    public static AjaxReponse success(Object data, String message){
        AjaxReponse ajaxReponse = AjaxReponse.builder()
                .isOk(true)
                .code(200)
                .message(message)
                .data(data)
                .build();
        return ajaxReponse;
    }
}
