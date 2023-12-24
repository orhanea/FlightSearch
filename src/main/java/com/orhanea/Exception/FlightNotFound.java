package com.orhanea.Exception;

public class FlightNotFound extends RuntimeException{
    public FlightNotFound(String message) {
        super(message);
    }
}
