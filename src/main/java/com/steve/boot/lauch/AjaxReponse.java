package com.steve.boot.lauch;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder(value = {"ok","code"})
@Schema(description = "common response data structure ")
public class AjaxReponse {
    @Schema(description = "true if it requests successfully.")
    private boolean ok;
    @Schema(description = "response code, 200 means successful", title = "200, 400, 500")
    private int code ; //"200|400|500"
    @Schema(description = "description for this request.")
    private String message;
    @Schema(description = "response data ")
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
