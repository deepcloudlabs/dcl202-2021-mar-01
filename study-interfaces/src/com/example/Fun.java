package com.example;

@SuppressWarnings("unused")
public abstract interface Fun {
	public static final int x = 42; // global constant
	abstract public void fun();
	// since java se 8
	// 1. default method
	default public void gun() {
		System.err.println("have gun...");
	};
	// 2. static method -> functional programming utility method
	public static void sun() {
		System.err.println("have sun...");
	}
	// since java se 9
	// 1. private method
	private void run() { // is called by default/private methods
		System.err.println("have run...");
	}
	// 2. private static method
	private static void hun() { // is called by all other methods
		System.err.println("have hun...");
	}
	
}

class A implements Fun {

	@Override
	public void fun() {
		System.err.println("have fun...");
	}
	
}