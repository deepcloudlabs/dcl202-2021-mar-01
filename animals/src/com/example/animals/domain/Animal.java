package com.example.animals.domain;

public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}
	
	public void walk() { // concrete -> { }
		System.err.println(
		  String.format("Animal with %d legs is walking now...", legs)
		);
	}
	public abstract void eat(); // abstract
}
