package com.example.demo.enumconverter;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.duck.FlyEnum;
import com.example.demo.exception.InvalidEnumValueException;
@RequestParamConverter
public class StringToFlyEnumConverter implements Converter<String, FlyEnum> {

	@Override
	public FlyEnum convert(String source) {
			return FlyEnum.decode(source);
	}

}
