package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudyMap {

	public static void main(String[] args) {
		// Entry(Key -> Value)
		// HashMap, LinkedHashMap, TreeMap (Sorted by key)
		Map<String, Integer> areaCodes = new TreeMap<>((c1,c2)->c2.compareTo(c1));
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("izmir", 232);
		areaCodes.put("antalya", 242);
		System.out.println(areaCodes.get("izmir"));
		// loops
		// #1 keys
		for (var city : areaCodes.keySet())
			System.out.println(city+"\t: "+areaCodes.get(city));
		// #2 values
		for (var code : areaCodes.values())
			System.out.println(code);
		// #3 entries
		for (var entry : areaCodes.entrySet())
			System.out.println(entry.getKey()+"\t: "+entry.getValue());
		// inner loop
		areaCodes.forEach((city,code)->System.out.println(city+": "+code));
		areaCodes.keySet().forEach(System.out::println);
		areaCodes.values().forEach(System.out::println);
	}

}
