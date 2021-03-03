package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudyStringComparison {

	public static void main(String[] args) throws ParseException {
		List<String> names = new ArrayList<>();
		names.add("şule");
		names.add("şima");
		names.add("sema");
		names.add("zehra");
		names.add("ayşegül");
		names.sort(String::compareTo);
		System.out.println(names);
		String name1 = "müller";
		String name2 = "mueller";
		System.out.println("name1.equals(name2): "+name1.equals(name2));
		// Collation
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";
		String trExpension= "& ü ; ue & s ; ş" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);		
		System.out.println("name1.equals(name2): "+collator.equals(name1,name2));
		System.out.println("sima==şima: "+collator.equals("sima","şima"));
	    names.sort(collator::compare);
	    System.out.println(names);
	}

}
