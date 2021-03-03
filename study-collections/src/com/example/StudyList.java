package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// List: 1) Allows duplicates 2) Ordered -> Sortable
		//ArrayList: Random-access, adding to rear -> add()
		//           add(17, 108), remove(17) 
		//           performance: new ArrayList<Integer>(1_000_000);
		List<Integer> numbers = new LinkedList<>(); // diamond operator (Java 7)
		numbers.add(4);
		numbers.add(42);
		numbers.add(16);
		numbers.add(4);
		numbers.add(23);
		numbers.add(8);
		numbers.add(16);
		numbers.add(4);
		numbers.add(15);
        System.out.println(numbers);
        System.out.println(numbers.get(-2)); // 4
        System.out.println(numbers.get(4)); // 23
        numbers.add(3,15); // 4, 42, 16, 15, 4, 23, 8, ...
        System.out.println(numbers);
        System.out.println(numbers.size());
        numbers.remove(0);
        System.out.println(numbers); // 42, 16, 15, 4, 23, 8, ...
        numbers.sort(new Comparator<Integer>() { // anonymous class

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
        // Interface: SAM (Single Abstract Method) -> Functional Interface
        // Partial Order Function
        numbers.sort((Integer o1, Integer o2) -> {
        		return o2-o1;
        });
        numbers.sort( (o1,o2) -> o2-o1 ); // Java 8, Lambda Expression
        Collections.sort(numbers, (o1,o2) -> o2-o1 );
        System.out.println(numbers);
        System.out.println(numbers.contains(42));
        // for-each
        for (var number : numbers)
        	System.out.println(number);
        // inner loop (java 8+)
        numbers.forEach(number -> System.out.println(number));
        // method reference
        numbers.forEach(System.out::println);
	}

}
