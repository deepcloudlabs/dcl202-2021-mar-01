package com.example.banking.questions.q3;

public class Question3 {

	public static void main(String[] args) {
		C c = new C(2);
		A a = c;
		B b = c;
		System.out.println(a.x); // 12
		System.out.println(b.x); // 4
		System.out.println(c.x); // 2
		System.out.println(((A) c).x); // 12
		System.out.println(((B) c).x); // 4
		System.out.println(((A) b).x); // 12
		System.out.println(a.getX()); // 2
		System.out.println(b.getX()); // 2
		System.out.println(c.getX()); // 2
		System.out.println(((A) c).getX()); // 2
		System.out.println(((B) c).getX()); // 2
		System.out.println(((A) b).getX()); // 2
	}

}

class A {
	public int x;

	public A(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

class B extends A {
	public int x;

	public B(int x) {
		super(3 * x);
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

class C extends B {
	public int x;

	public C(int x) {
		super(2 * x);
		this.x = x;
	}

	public int getX() {
		return x;
	}
}
