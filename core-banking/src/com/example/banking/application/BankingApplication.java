package com.example.banking.application;

import java.util.function.Consumer;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;
import com.example.banking.domain.InsufficientBalanceException;

public class BankingApplication {

	public static void main(String[] args) {
		// account : reference variable -> Account object
		var account = new Account("tr1", 10_000);
		try {
			((Account)null).withdraw(1_000);
			account.withdraw(2_500);
			account.withdraw(5_000);
			account.deposit(1_000);
			account.withdraw(3_500);
			account.withdraw(0.01);
			// multi-catch (java se 7)
		} catch (InsufficientBalanceException | 
				 IllegalArgumentException     | 
			ArrayIndexOutOfBoundsException e) {
		   System.err.println("Reason: "+e.getMessage()); 			
	    } finally {
	    	System.err.println("Finally, we arrived here!");
	    }
		// sout + ctrl + space
		System.out.println(account.getBalance());
		// balance : private -> error
		// System.out.println(account.balance);
		System.out.println(account.toString());
		
		var customer = new Customer("11111111110", "jack bauer");
		customer.addAccount(new Account("tr1",10_000));
		customer.addAccount(new Account("tr2",20_000));
		customer.addAccount(new Account("tr3",30_000));
		System.out.println(customer.getNumberOfAccounts());
		// Functional Programming
		Consumer<Account> withdraw5000 = 
				acc -> {
					try{ acc.withdraw(5_000); }catch(InsufficientBalanceException e) {}
				};
		Consumer<Account> printAccount = System.out::println; 
		customer.getAccount("tr2")
		        .ifPresent(withdraw5000.andThen(printAccount));
		// Classical code
		var acc = customer.getAccount("tr2");
		if (acc.isPresent()) {
			var account2 = acc.get();
			try {
				account2.withdraw(5_000);
			} catch (InsufficientBalanceException e) {
				e.printStackTrace();
			}
			System.out.println(account2);
		}
	}
}
