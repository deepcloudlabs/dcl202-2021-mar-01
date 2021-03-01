package com.example;

public class StudyString {

	public static void main(String[] args) {
		String name1 = "jack"; // static -> object pool (cache) 
		String name2 = new String("jack"); // dynamic -> heap
		String name3 = "jack"; // static -> object pool (cache)
		name2 = name2.intern() ; // name2 -> object pool (cache)
		System.out.println("name1==name2 ? "+(name1==name2)); // false -> true
		System.out.println("name1==name3 ? "+(name1==name3)); // true
	}

}
