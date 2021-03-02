package com.example;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		// Floating-Point Numbers: IEEE-754 v5
		// float, 4-Byte
		float f = (float) 3.141516;
		float g = 3.141516F;
		g = 1_000_000_000F;
		System.out.println(String.format("g=%16.3f", g));
		g = g + 50;
		System.out.println(String.format("g=%16.3f", g));

		// double, 8-Byte, default
		double x = 2.0;
		x = x - 1.10;
		System.out.println(String.format("x=%3.16f", x));
		double y = (0.1 + 0.2) + 0.3;
		double z = 0.1 + (0.2 + 0.3);
		System.out.println("y==z: "+(y == z));
		System.out.println(String.format("y=%3.16f", y));
		System.out.println(String.format("z=%3.16f", z));
		// BigDecimal -> Immutable Class
		BigDecimal bd = BigDecimal.valueOf(2);
		bd = bd.subtract(BigDecimal.valueOf(1.1));
		System.out.println("bd="+bd);
		double p = -1 / 0.; // FPU
		System.out.println("p="+p);
		double q = 0 / 0.; // FPU
		System.out.println("q="+q);
		q++;
		System.out.println("q="+q);
		double r = 0 / 0.; // FPU
		System.out.println("q==q ? "+(q==q));
		System.out.println(Double.isNaN(r));
	}

}
