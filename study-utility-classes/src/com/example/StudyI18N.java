package com.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class StudyI18N {

	public static void main(String[] args) {
		Locale tr = Locale.US; // new Locale("tr", "TR");
		var bundle = ResourceBundle.getBundle("messages", tr);
		String fullname= "Jack Bauer";
		var formatter = new MessageFormat(bundle.getString("greeting"),tr);
		System.out.println(formatter.format(new Object[] {fullname}));

	}

}
