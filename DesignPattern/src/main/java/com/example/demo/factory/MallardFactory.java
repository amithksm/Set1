package com.example.demo.factory;

import com.example.demo.duck.Duck;
import com.example.demo.duck.MallardDuck;

public class MallardFactory implements IDuckFactory{

	@Override
	public Duck getDuckInstance() {
		return new MallardDuck();
	}

}
