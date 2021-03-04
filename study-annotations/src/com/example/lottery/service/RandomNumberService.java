package com.example.lottery.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.example.lottery.model.RandomNumber;

public class RandomNumberService {
	public void generate(Object o) throws Exception {
		// Reflection
		var clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumber = field.getAnnotation(RandomNumber.class);
				var numbers = generateNumbers(randomNumber);
				try {
					field.setAccessible(true);
					field.set(o, numbers); // reflection
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.println("Error: "+e.getMessage());
					throw e; // re-throw
				}
			}
		}
	}

	private List<Integer> generateNumbers(RandomNumber randomNumber) {
		var min = randomNumber.min();
		var max = randomNumber.max();
		var size = randomNumber.size();
		var sorted = randomNumber.sorted();
		var unique = randomNumber.unique();
		var stream = ThreadLocalRandom.current().ints(min, max);
		if (unique)
			stream = stream.distinct();
		stream = stream.limit(size);
		if (sorted)
			stream = stream.sorted();
		return stream.boxed().collect(Collectors.toList());
	}
}
