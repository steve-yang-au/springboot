package com.steve.boot.launch.exception;

public class CustomException extends RuntimeException{
    private int code;
    private String message;
    private CustomException(){}
    public CustomException(CustomExceptionType enumType){
        this.code = enumType.getCode();
        this.message = enumType.getDescription();
    }
    public CustomException(CustomExceptionType enumType, String message){
        this.code = enumType.getCode();
        this.message = message;
    }

    public int getCode(){return code;}

    @Override
    public String getMessage(){
        return message;
    }
}
