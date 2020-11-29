package com.example.demo.duck;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Duck{
	
	@JsonIgnore 
	public FlyBehaviour flyBehaviour;
	public int size;
	public ColorEnum color;
	public DuckEnum duckType;
	public Long duckId;
	
	public abstract String performFly();

}
