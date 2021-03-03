package com.example;

import java.util.Locale;

public class StudyString {

	public static void main(String[] args) {
		// String: immutable class -> object caching/pooling
		String name = "jack"; 
		System.out.println(name);
		name = name.toUpperCase();
		System.out.println(name);
		var city = "izmir";
		// Internationalization: i18n
		var tr = new Locale("tr","TR"); 
		System.out.println(city);
		city = city.toUpperCase(tr); // supports i18n
		System.out.println(city);
	}

}
