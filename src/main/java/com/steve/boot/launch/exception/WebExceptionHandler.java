package com.steve.boot.launch.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        return AjaxReponse.error(CustomException.defaultCustomException(CustomExceptionType.USER_INPUT_ERROR), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxReponse handleIllegalArgumentExceptionException(IllegalArgumentException e){
        return AjaxReponse.error(CustomException.defaultCustomException(CustomExceptionType.USER_INPUT_ERROR),e.getMessage());
    }
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxReponse bindException(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxReponse.error(CustomException.defaultCustomException(CustomExceptionType.USER_INPUT_ERROR), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxReponse exception(Exception e){

        //TODO put unexpected error message save to file system or database
        return AjaxReponse.error(CustomException.defaultCustomException(CustomExceptionType.OTHER_ERROR));
    }

    @ExceptionHandler(ModelViewException.class)
    public ModelAndView handleModelAndView(HttpServletRequest request, ModelViewException e){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("exception", e);
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
