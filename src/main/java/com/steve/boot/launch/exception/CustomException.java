package com.steve.boot.launch.exception;

public class CustomException extends RuntimeException{
    private final int code;
    private final String message;
    private CustomException(int code, String message){
        this.code = code;
        this.message = message;
    }
    public static CustomException defaultCustomException(CustomExceptionType enumType){
        return new CustomException(enumType.getCode(), enumType.getDescription());
    }
    public CustomException defaultCustomException(CustomExceptionType enumType, String message){
        return new CustomException(enumType.getCode(), message);
    }

    public int getCode(){return code;}

    @Override
    public String getMessage(){
        return message;
    }
}
