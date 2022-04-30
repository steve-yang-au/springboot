package com.steve.boot.launch.exception;

public enum CustomExceptionType {

    USER_INPUT_ERROR(400, "the data you inputted is not right," ),
    SYSTEM_ERROR(500,"the system has an exception, please try again later."),
    OTHER_ERROR(999, "an unexpected error occurred, please report it to the owner. ");
    private String description;
    private int code;

    CustomExceptionType(int code, String description){
        this.code = code;
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public int getCode() {
        return code;
    }
}
