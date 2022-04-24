package com.example.sr.exception;


public class ActiveMatchAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = -4128924004608078109L;

    public ActiveMatchAlreadyExists() {
        super("Active match already exists");
    }
	
}
