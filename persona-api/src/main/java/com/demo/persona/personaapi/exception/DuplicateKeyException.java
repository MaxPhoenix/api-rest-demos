package com.demo.persona.personaapi.exception;

public class DuplicateKeyException extends Exception{
	
	public DuplicateKeyException() {
		
	}
	
	public DuplicateKeyException(String message) {
        super(message);
    }
}
