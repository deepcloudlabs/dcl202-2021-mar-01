package com.example;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unused")
public class StudyArrays {

	public static void main(String[] args) {
		int number = 42; // scalar variable
		Integer numbers1 []; // array
		int [] numbers2 = {4,8,15,16,23,42}; // array

		numbers1 = new Integer[10]; // 10 elements: 0,0,0,0,0,0,0,0,0,0
		System.out.println(numbers1.length);
		numbers1 = new Integer[] {4,8,15,16,23,42}; // 6 elements
		System.out.println(numbers1.length);
		
		// static: numbers1.length is constant
		System.out.println(numbers1[5]); // 42
		System.out.println(numbers1[numbers1.length-1]); // 42
		// System.out.println(numbers1[-1]); // ArrayIndexOutOfBoundsException
		
		// Outer Loop over arrays #1
		for (var i=0;i<numbers1.length;i += 3) {
			System.out.println(numbers1[i]);
		}
		for (var i=numbers1.length-1;i>=0;i-=2) {
			System.out.println(numbers1[i]);
		}
		// Outer Loop over arrays #2 (Java SE 5) : for-each -> read-only
		for (int num : numbers1) { // SAFE: ArrayIndexOutOfBoundsException
			System.out.println(num);
			num = num * 2; // does not change the original array
		}
		for (var num : numbers1) { // SAFE: ArrayIndexOutOfBoundsException
			System.out.println(num);			
		}
		// Inner Loop over arrays #3: Stream API (Java SE 8)
		Arrays.stream(numbers1).forEach(System.out::println);
		// Arrays: utility class
		Arrays.sort(numbers1,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		// Functional Programming
		Arrays.sort(numbers1, (o1,o2) -> o2-o1 ); // Lambda Expression
		// Functional Interface : Comparator
		Comparator<Integer> orderByAsc = Integer::compare; // Method Reference
		Arrays.sort(numbers1, orderByAsc.reversed()); // Lambda Expression
		
		System.out.println(Arrays.toString(numbers1));
		
	}

}
