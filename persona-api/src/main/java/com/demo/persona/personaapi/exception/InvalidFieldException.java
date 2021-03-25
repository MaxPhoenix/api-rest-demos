package com.demo.persona.personaapi.exception;

public class InvalidFieldException extends Exception{
	
	public InvalidFieldException() {
		
	}
	
	public InvalidFieldException(String message) {
        super(message);
    }
}
