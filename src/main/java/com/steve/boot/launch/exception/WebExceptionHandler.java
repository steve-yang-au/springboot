package com.steve.boot.launch.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxReponse handleBindException(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxReponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxReponse handleIllegalArgumentExceptionException(IllegalArgumentException e){
        return AjaxReponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR),e.getMessage());
    }
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxReponse BindException(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxReponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxReponse exception(Exception e){

        //TODO put unexpected error message save to file system or database
        return AjaxReponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }
}
