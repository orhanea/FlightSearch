package com.orhanea.Exception;

public class AirportNotFound extends RuntimeException{
    public AirportNotFound(String message) {
        super(message);
    }

}