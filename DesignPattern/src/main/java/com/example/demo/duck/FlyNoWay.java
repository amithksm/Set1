package com.example.demo.duck;

public class FlyNoWay implements FlyBehaviour{

	@Override
	public String fly() {
		System.out.println("Cannot fly ");
		return "Cannot fly";
	}
	
	

}
