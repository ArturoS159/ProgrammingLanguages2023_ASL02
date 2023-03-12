package com.artur;

public class NoFuelException extends RuntimeException {
    public NoFuelException() {
    }

    public NoFuelException(String message) {
        super(message);
    }
}
