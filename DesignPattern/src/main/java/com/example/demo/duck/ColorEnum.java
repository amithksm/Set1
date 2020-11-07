package com.example.demo.duck;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ColorEnum {
	
	RED("RED"),
	GREEN("GREEN"),
	BLUE("BLUE");
	
	private String color;
	
	private ColorEnum(String cc) {
		this.color = cc;
	}
	
	@JsonCreator
	public static ColorEnum decode(final String inputColor) {
		
		return Stream.of(ColorEnum.values())
			.filter(x -> x.color.equals(inputColor))
			.findFirst()
			.orElse(null);
		// To Do: throw custom exception and handle the exception global exception handler
	}
	
	@JsonValue
	public String getCode() {
		return color;
	}

}
