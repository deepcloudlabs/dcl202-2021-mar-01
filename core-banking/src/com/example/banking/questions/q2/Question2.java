package com.example.banking.questions.q2;

@SuppressWarnings("unused")
public class Question2 {
	public static void main(String[] args) {
		B b = new B();
		// D's constructor
		// A's constructor
		// C's constructor
		// E's constructor
		// B's constructor
	}
}

@SuppressWarnings("unused")
class A {
	private D d = new D();

	public A() {
		System.out.println("A's constructor");
	}
}

@SuppressWarnings("unused")
class B extends A {
	private E e = new E();

	public B() {
		System.out.println("B's constructor");
	}
}

@SuppressWarnings("unused")
class C {
	public C() {
		System.out.println("C's constructor");
	}
}

@SuppressWarnings("unused")
class D {
	public D() {
		System.out.println("D's constructor");
	}
}

@SuppressWarnings("unused")
class E {
	private C c = new C();

	public E() {
		System.out.println("E's constructor");
	}
}