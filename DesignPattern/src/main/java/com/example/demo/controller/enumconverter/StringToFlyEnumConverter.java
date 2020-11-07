package com.example.demo.controller.enumconverter;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.duck.FlyEnum;
import com.example.demo.exception.InvalidEnumValueException;
@RequestParamConverter
public class StringToFlyEnumConverter implements Converter<String, FlyEnum> {

	@Override
	public FlyEnum convert(String source) {
		try {
			return FlyEnum.decode(source);
		} catch (InvalidEnumValueException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
