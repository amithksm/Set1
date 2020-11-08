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
	public static FlyEnum decode(final String inputFly) {
		
		return Stream.of(FlyEnum.values())
			.filter(x -> x.flyingStyle.equals(inputFly))
			.findFirst()
			.orElseThrow(() -> new InvalidEnumValueException("Invalid FlyEnum "+inputFly));
//		<https://stackoverflow.com/questions/36190246/handling-exception-in-spring-boot-rest-thrown-from-custom-converter>
	}
	
	@JsonValue
	public String getCode() {
		return flyingStyle;
	}

}
