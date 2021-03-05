package com.example;

import java.text.DecimalFormat;
import java.util.Locale;

public class StudyCurrency {

	public static void main(String[] args) {
		var money = 12_345_678.9;
		Locale locale = Locale.JAPAN; // new Locale("tr", "TR");
		var df = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
		//var dfs = DecimalFormatSymbols.getInstance(locale);
		//dfs.setCurrencySymbol("\u20BA");
		//df.setDecimalFormatSymbols(dfs);
		System.out.println(df.format(money));
	}

}
