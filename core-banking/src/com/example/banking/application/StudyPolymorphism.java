package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

public class StudyPolymorphism {

	public static void main(String[] args) {
		// Class -> Encapsulation ( + information hiding principle)
		// Inheritance -> Reusability
		// Polymorphism -> Agility (Open/Close Principle)

		Account account = null;

		if (ThreadLocalRandom.current().nextBoolean())
			account = new Account("tr1", 10_000);
		else
			account = new CheckingAccount("tr1", 10_000, 2_500);
		System.out.println(account.getClass().getName());
		account.withdraw(3_500); // ?
		// Polymorphism -> Run-time polymorphism
		// Reference variable -> T2 -> account -> Account
		// 1. Inheritance: Account <- CheckingAccount
		// 2. Super class reference : Account -> account
		// 3. Polymorphic Methods: deposit, withdraw, toString, getClass, equals, hashCode, ... 
	    //    account.withdraw(1_000);   
		Object o = 42;
		o = 3.14;
		o = '\u20BA';
		o = "jack";
		o = new CheckingAccount("tr1", 10_000, 2_500);
		o = int.class;
		o = int[].class;
		o.toString() ; // toString, getClass, equals, hashCode, ...
	}

}
