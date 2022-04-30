package com.steve.boot.launch.exception;

public class ModelViewException extends RuntimeException{

    public ModelViewException(Throwable cause) {
        super(cause);
    }

    public static ModelViewException transfer(Throwable cause){
        return new ModelViewException(cause);
    }
}
