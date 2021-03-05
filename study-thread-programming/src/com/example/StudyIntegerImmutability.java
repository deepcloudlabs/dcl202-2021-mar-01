package com.example;

public class StudyIntegerImmutability {

	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=2048
		Integer x = Integer.valueOf(42); // Auto Boxing
		Integer y = 42;
		Integer u = 549;
		Integer v = 549;
		System.out.println("x==y: "+(x==y));
		System.out.println("u==v: "+(u==v));

	}

}
