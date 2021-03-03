package com.example;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class StudyDateTimeFormatter {

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		Locale tr = Locale.JAPAN; // new Locale("tr", "TR");
		var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)
				                   .withLocale(tr);
		System.out.println(dtf.format(now));
	}

}
