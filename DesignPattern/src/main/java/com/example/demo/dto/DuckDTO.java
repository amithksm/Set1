package com.example.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.demo.duck.ColorEnum;
import com.example.demo.duck.DuckEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DuckDTO {
	
	@Min(value = 1, message = "Size should be min 1")
	@Max(value = 15, message = "Size should be max 15")
	@NotNull(message = "Size should not be Null")
	Integer size;
	
	@NotNull(message = "Color should not be Null")
	ColorEnum color;
	
	@NotNull(message = "duckType should not be Null")
	DuckEnum duckType;
	
}
