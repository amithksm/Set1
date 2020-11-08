package com.example.demo.exception;

public class InvalidEnumValueException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEnumValueException(String errMessage) {
        super(errMessage);
    }
	

}
