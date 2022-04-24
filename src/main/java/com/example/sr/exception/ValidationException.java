package com.example.sr.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -7319550251891937928L;

    public ValidationException(String msg) {
        super(msg);
    }
}
