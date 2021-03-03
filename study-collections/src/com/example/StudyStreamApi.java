package com.example;

import java.util.List;

public class StudyStreamApi {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(4,8,15,16,23,42);
		var sum = 0;
		// loop outside collection
		for (var number : numbers) {
			if (number % 2 == 0) {
				var squared = number * number;
				sum += squared;
			}
		}
		System.out.println("Sum= "+sum);
		// Stream API: filter/map/reduce (Hadoop: 1) HDFS 2) MapReduce )
		sum= numbers.stream() // 4, 8, 15, 16, 23, 42
				.parallel() // ForkJoin Framework -> Job Stealing Algorithm
				.peek(System.err::println)
		       .filter(number -> number%2 == 0) //  4,  8,  16, 42
		       .peek(System.err::println)
		       .map(number -> number * number)  // 16, 64, 256, 1764
		       .peek(System.err::println)
		       .reduce(0, (acc, number) -> acc + number); // terminal 
		        // 0 -> (0,16) -> 16 -> (16,64) -> 80 -> (80,256) -> 336
		        // (336, 1764) -> 2100
		System.out.println("Sum= "+sum);	
		// stream api methods: 1) intermediary methods 2) terminal methods
		//                    lazy evaluation  
		// (1) filter, map, distinct, limit, flatMap, stream, parallel, ...
		// (2) reduce, sum, min, max, count, ...
		var numOfEvens = numbers.stream()
				                .filter(number -> number%2 == 0)
				                //.map( number -> 1)
				                //.reduce(0, (acc, number) -> acc + number);
				                .count(); // terminal
		System.out.println("numOfEvens: "+numOfEvens);
		
	}

}
