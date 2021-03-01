package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		// Integral Types: Signed
		// byte (1-Byte) [-128..127]
		byte b = 127;
		System.out.println("b="+b);
		b++; // b = (byte) ( b + 1 );
		System.out.println("b="+b); // -128
		b--;
		System.out.println("b="+b); // 127
		// short (2-Byte) [-32768..32767]
		short s = Short.MAX_VALUE;
		System.out.println("s="+s);
		s++;
		System.out.println("s="+s);
		// int (4-Byte) [-2147483648..2147483647]
		int i = Integer.MAX_VALUE;
		System.out.println("i="+i);
		i++;
		System.out.println("i="+i);
		// long (8-Byte) [-9223372036854775808..9223372036854775807]
		long l = Long.MAX_VALUE;
		System.out.println("l="+l);
		l++; 
		System.out.println("l="+l);
		byte x=127,y=1,z;
		z = (byte) (x + y); // JLS
		System.out.println("z="+z);
		// int j = -1 / 0;
		//int k = 0 / 0;
		long m = 1234567 + 765432L;
		System.out.println("m= "+m);
		long n = 2147483647 + 1L;
		System.out.println("n="+n);
		long p = 9223372036854775807L;
		p++;
		System.out.println("p="+p);
		// BigInteger: Immutable Class
		BigInteger q = BigInteger.valueOf(9223372036854775807L);
		q = q.add(BigInteger.ONE);
		System.out.println("q="+q);
	}

}
