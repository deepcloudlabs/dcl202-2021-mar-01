package com.example.banking.application;

public class StudyFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// 1. Extensibility
final class A { // final class -> you cannot extend final class
	
}
class D {
	public final void fun() {} // final method -> you cannot override final method
}
// error: class B extends A { }
class C extends D {
	// error: @Override public void fun() {}
}

// 2. Immutability

@SuppressWarnings("unused")
class E {
	private final int x = 42; // constant
	private final int y; // constant
	
	public E(int y) {
		this.y = y; // constant value
	}
	
	public void fun(final int z) {
		// errror: z++;
	}
	
	public void gun() {
		final int u= 42;
		// error : u++;
	}
}