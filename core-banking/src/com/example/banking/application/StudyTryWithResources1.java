package com.example.banking.application;

import java.io.Closeable;
import java.io.IOException;

public class StudyTryWithResources1 {

	public static void main(String[] args) {
		var res1 = new PreciousResource(1);
		var res2 = new PreciousResource(2);
		var res3 = new PreciousResource(3);
		try {
			throw new IllegalArgumentException("An error has occured.");
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println("Error while closing resource 1: "+e.getMessage());
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println("Error while closing resource 2: "+e.getMessage());
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println("Error while closing resource 3: "+e.getMessage());
					}												
				}
			}
		}
		

	}

}
