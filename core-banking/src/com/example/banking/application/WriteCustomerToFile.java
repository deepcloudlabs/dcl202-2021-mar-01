package com.example.banking.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

public class WriteCustomerToFile {

	public static void main(String[] args) throws Exception {
		var jack = new Customer("1111111110", "Jack Bauer");
		jack.addAccount(new Account("tr1", 100_000));
		jack.addAccount(new CheckingAccount("tr2", 200_000, 5_000));
		jack.addAccount(new Account("tr3", 300_000));
		var file = new File("c:/tmp", "jack.dat");
		// try-with-resources, Java 7+
		try (var fos = new FileOutputStream(file); 
			 var oos = new ObjectOutputStream(fos);) {
			oos.writeObject(jack);
		}
        System.err.println("Object is written to the file.");
	}

}
