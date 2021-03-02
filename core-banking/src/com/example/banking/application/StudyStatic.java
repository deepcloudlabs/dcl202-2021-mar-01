package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import static com.example.banking.domain.Account.getNumberOfAccounts;

public class StudyStatic {

	public static void main(String[] args) {
		System.out.println(getNumberOfAccounts());
		var acc1 = new Account("tr1", 10_000);
		var acc2 = new CheckingAccount("tr2", 10_000,1_000);
		var acc3 = new Account("tr3", 10_000);
		System.out.println(Account.getNumberOfAccounts());
		Account acc = null;
		System.out.println(acc.getNumberOfAccounts());
		System.out.println(((Account)null).getNumberOfAccounts());
	}

}
