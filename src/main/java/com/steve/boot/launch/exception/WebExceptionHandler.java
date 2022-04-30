package com.steve.boot.launch.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxReponse customerException(CustomException e){
        if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            //TODO put system error message save to file system or database
        }
        return AjaxReponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxReponse exception(Exception e){

        //TODO put unexpected error message save to file system or database
        return AjaxReponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }
}
