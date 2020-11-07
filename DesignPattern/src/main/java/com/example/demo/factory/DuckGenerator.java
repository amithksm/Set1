package com.example.demo.factory;

import org.springframework.stereotype.Component;

import com.example.demo.duck.Duck;
import com.example.demo.duck.DuckEnum;
@Component
public class DuckGenerator {
	
	public Duck generateDuck(DuckEnum duckType) {
		
		switch(duckType) {
			case MALLARD:
				return new MallardFactory().getDuckInstance();
			case RUBBER:
				return new RubberDuckFactory().getDuckInstance();
			
		default:
			return null;
		}
	}

}
