package com.demo.pelicula.peliculaapi.exception;

public class InvalidFieldException extends Exception{
	
	public InvalidFieldException() {
		
	}
	
	public InvalidFieldException(String message) {
        super(message);
    }
}
