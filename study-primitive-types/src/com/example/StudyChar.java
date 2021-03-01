package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'a'; // 2-Byte, Unicode, Integral Type (unsigned int)
		System.out.println("c="+(char)(c+0));
		System.out.println("c="+(char)(c+1));
		char d = '\u20BA';
		System.out.println("d="+d);
	}

}
