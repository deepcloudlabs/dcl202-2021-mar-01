package com.example.banking.application;

import java.io.IOException;

public class StudyTryWithResources2 {

	public static void main(String[] args) {
		try ( // java se 7 : try with resources
				var res1 = new PreciousResource(1); // Autoclosable
				var res2 = new PreciousResource(2);
				var res3 = new PreciousResource(3);				
				) {
			throw new IllegalArgumentException("An error has occured.");
		}catch(IOException e) {
			System.err.println("Error: "+e.getMessage());
		} 	
	
	}

}

