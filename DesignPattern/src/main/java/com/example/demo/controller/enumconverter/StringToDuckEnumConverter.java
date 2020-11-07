package com.example.demo.controller.enumconverter;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.duck.DuckEnum;

@RequestParamConverter
public class StringToDuckEnumConverter implements Converter<String, DuckEnum> {

	@Override
	public DuckEnum convert(String code) {
		return DuckEnum.decode(code);
	}

}
