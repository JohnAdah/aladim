package com.trader.smarttrade.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


}
