package com.example.banking.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

public class ReadCustomerFromFile {

	public static void main(String[] args) throws Exception {
		var file = new File("c:/tmp", "jack.dat");
		// try-with-resources, Java 7+
		try (var fis = new FileInputStream(file); 
			 var ois = new ObjectInputStream(fis);) {
			Customer jack = (Customer) ois.readObject();
			System.err.println(jack);
			var totalBalance = jack.getTotalBalance();
			System.err.println("Total balance: "+totalBalance);
		}
	}

}
