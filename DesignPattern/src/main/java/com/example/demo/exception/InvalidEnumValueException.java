package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.util.StringUtils;

public class InvalidEnumValueException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEnumValueException(String errMessage) {
        super(errMessage);
    }
	

}
