package com.example.sr.exception;

public class ValidationError extends RuntimeException {

	private static final long serialVersionUID = -7319550251891937928L;

    public ValidationError(String msg) {
        super(msg);
    }
}
