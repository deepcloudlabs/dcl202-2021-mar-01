package com.example;

public class StudyDynamicString {

	public static void main(String[] args) {
		// StringBuffer: TS, StringBuilder: NOT TS
		var s = new StringBuffer(488891); 
		var start = System.currentTimeMillis();
		for (var i=0;i<2_000_000;++i) {
			s.append(i); // dynamic string
		}
		var stop = System.currentTimeMillis();
		System.out.println("s.length(): "+s.length()
		 + ", duration: " + (stop-start) + " ms.");
	}

}
