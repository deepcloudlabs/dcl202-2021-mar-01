package com.example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// Set: 1) Unique 2) Unordered -> Unsortable
		// Implementations: HashSet, LinkedHashSet, TreeSet
		// HashSet: Chaotic
		// LinkedHashSet: Insertion order
		// TreeSet: Sorted (Red-Black Tree)
		Set<Integer> numbers = new TreeSet<>((o1,o2)->o2-o1); 
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
        // System.out.println(numbers.get(0)); // unordered
		// numbers.sort() // unordered
        System.out.println(numbers.contains(42)); // HashSet -> O(1)
        for (var number : numbers)
        	System.out.println(number);
        // inner loop (java 8+)
        numbers.forEach(number -> System.out.println(number));
        // method reference
        numbers.forEach(System.out::println);
	}

}
