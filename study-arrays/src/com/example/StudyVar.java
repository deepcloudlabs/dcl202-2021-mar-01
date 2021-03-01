package com.example;

public class StudyVar {
	//Error: var z = 42; // instance variable
	Object k= "Jack";
	public static void main(String[] args) {
		var x = "2"; // compiler: x -> String 
		//x = 3.1415;
		x = "Jack";
		x.toLowerCase();
        Object y = 42; // y -> Object (class) -> reference
        y = 3.1415;
        y = "Jack";
        y = true;
        // Error: y.toLowerCase()
	}

}
