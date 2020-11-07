package com.example.demo.duck;

import java.util.stream.Stream;

import com.example.demo.exception.InvalidEnumValueException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FlyEnum {
	

	WINGS("WITHWINGS"),
	NOFLY("NOFLY");
	
	private String flyingStyle;
	
	private FlyEnum(String cc) {
		this.flyingStyle = cc;
	}
	
	@JsonCreator
	public static FlyEnum decode(final String inputFly) throws InvalidEnumValueException {
		
		return Stream.of(FlyEnum.values())
			.filter(x -> x.flyingStyle.equals(inputFly))
			.findFirst()
			.orElseThrow(() -> new InvalidEnumValueException("Invalid FlyEnum "+inputFly));
			//.orElse(null);
		// To Do: throw custom exception and handle the exception global exception handler
	}
	
	@JsonValue
	public String getCode() {
		return flyingStyle;
	}

}
