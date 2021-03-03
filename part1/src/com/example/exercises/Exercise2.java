package com.example.exercises;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		var countries = countryDao.findAllCountries();
		var stream = countries.stream();
		if (countries.size()>1_000)
			stream = stream.parallel();
		var continents = stream
		     .map(Country::getContinent)
		     .distinct()
		     .sorted((c1,c2)->c2.compareTo(c1))
		     .collect(Collectors.toList()); // terminal
		System.out.println(continents);
	}

}