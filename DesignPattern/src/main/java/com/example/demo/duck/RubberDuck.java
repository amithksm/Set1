package com.example.demo.duck;

public class RubberDuck extends Duck{
	
	
	public RubberDuck(int size, ColorEnum color) {
		this.flyBehaviour = new FlyNoWay();
		this.size = size;
		this.color = color;
	}
	
	public RubberDuck() {
		this.flyBehaviour = new FlyNoWay();
		this.duckType = DuckEnum.RUBBER;
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
