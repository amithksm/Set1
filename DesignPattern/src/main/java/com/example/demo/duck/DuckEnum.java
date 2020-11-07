package com.example.demo.duck;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DuckEnum {
	
	MALLARD("MALLARD"),
	RUBBER("RUBBER");
	
	private String code;
	
	private DuckEnum (String code) {
		this.code = code;
	}
	
	@JsonCreator
	public static DuckEnum decode(final String code) {
		return Stream.of(DuckEnum.values())
				.filter(x -> x.code.equals(code))
				.findFirst()
				.orElse( null);
		// To Do: throw custom exception and handle the exception global exception handler
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}

}
