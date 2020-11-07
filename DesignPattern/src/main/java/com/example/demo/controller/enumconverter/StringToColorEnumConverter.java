package com.example.demo.controller.enumconverter;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.duck.ColorEnum;

@RequestParamConverter
public class StringToColorEnumConverter implements Converter<String, ColorEnum> {
    
	@Override
    public ColorEnum convert(String source) {
        return ColorEnum.decode(source);
    }
}
