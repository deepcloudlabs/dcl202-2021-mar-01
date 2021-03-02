package com.example.animals.application;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

public class ZooApplication {

	public static void main(String[] args) {
		List<Animal> animals = List.of(
			new Spider(), 
			new Cat(), 
			new Fish("Free Willy"),
			new Spider(), 
			new Cat("Tekir"), 
			new Fish("Jaws")
		);
		for (var animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) { // guard
				((Pet)animal).play();
			}
		}
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::walk;
		Consumer<Animal> playIfPet = animal -> {
			if (animal instanceof Pet) ((Pet)animal).play() ;
		};
		System.err.println("parallel solution starts now...");
		animals.parallelStream().forEach(walk.andThen(eat).andThen(playIfPet));
		Predicate<Animal> isPet = Pet.class::isInstance;
		Predicate<Animal> isWild = isPet.negate();
		var numberOfPets = 
				animals.stream().parallel().filter(isPet).count();
		var numberOfWild = 
				animals.stream().parallel().filter(isWild).count();
		System.err.println("Number of pets is "+numberOfPets);
		System.err.println("Number of wild animals is "+numberOfWild);
	    numberOfPets = 0;
	    for (var animal : animals) {
	    	if (animal instanceof Pet)
	    		numberOfPets++;
	    }	
	}

}
