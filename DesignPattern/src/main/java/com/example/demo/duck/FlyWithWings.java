package com.example.demo.duck;

public class FlyWithWings implements FlyBehaviour{

	@Override
	public String fly() {
		System.out.println("Flying with wings");
		return "Flying with wings";
	}

}
