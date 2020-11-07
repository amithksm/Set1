package com.example.demo.duck;

import lombok.Data;

@Data
public class MallardDuck extends Duck{
	
	
	public MallardDuck(int size, ColorEnum color) {
		this.flyBehaviour = new FlyWithWings();
		this.size = size;
		this.color = color;
	}
	
	public MallardDuck() {
		this.flyBehaviour = new FlyWithWings();
		this.duckType = DuckEnum.MALLARD;
	}

	@Override
	public String toString() {
		return this.duckType + " of size " + this.size + " color " + this.color;
	}
	

	@Override
	public String performFly() {
		 return this.duckType + " " + this.flyBehaviour.fly();
	}

}
