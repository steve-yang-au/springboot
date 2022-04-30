package com.steve.boot.launch.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonPropertyOrder(value = {"ok","code"})
@Schema(description = "common response data structure ")
public class AjaxReponse {
    @Schema(description = "true if it requests successfully.")
    private boolean ok;
    @Schema(description = "response code, 200 means successful", title = "200, 400, 500,999")
    private int code ; //"200|400|500"
    @Schema(description = "description for this request.")
    private String message;
    @Schema(description = "response data ")
    private Object data;

    private AjaxReponse(){}

    public static AjaxReponse error(CustomException e){
        AjaxReponse returnBean = new AjaxReponse();
        returnBean.setCode(e.getCode());
        returnBean.setOk(false);
        returnBean.setMessage(e.getMessage());
        return returnBean;
    }

    public static AjaxReponse error(CustomException e, String errorMessage){
        AjaxReponse returnBean = new AjaxReponse();
        returnBean.setCode(e.getCode());
        returnBean.setOk(false);
        returnBean.setMessage(errorMessage);
        return returnBean;
    }

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
                .data(null)
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
