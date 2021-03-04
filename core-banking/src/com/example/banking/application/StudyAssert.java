package com.example.banking.application;

import com.example.banking.domain.Account;

public class StudyAssert {

	public static void main(String[] args) {
		var acc = new Account("tr1", 10_000);
		acc.deposit(500);
		System.out.println(acc);
	}

}
