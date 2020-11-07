package com.example.demo.factory;

import com.example.demo.duck.Duck;
import com.example.demo.duck.RubberDuck;

public class RubberDuckFactory implements IDuckFactory{

	@Override
	public Duck getDuckInstance() {
		return new RubberDuck();
	}

}
