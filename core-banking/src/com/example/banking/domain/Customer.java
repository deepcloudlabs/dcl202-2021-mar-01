package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DDD: Entity Class -> Persistent, Identity
public class Customer {
	private final String identity; // does allow to change
	private String fullName;
	private List<Account> accounts;

	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
		accounts = new ArrayList<>(); // empty list
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}

	// business methods
	public void addAccount(Account account) {
		accounts.add(account);
	}

	// overloaded: getAccount, signature: int
	public Optional<Account> getAccount(int index) {
		if (index < 0 || index >= accounts.size())
			return Optional.empty();
		return Optional.of(accounts.get(index));
	}

	// overloaded: getAccount, signature: String
	public Optional<Account> getAccount(String iban) {
		for (var account : accounts)
			if (account.getIban().equals(iban))
				return Optional.of(account);
		return Optional.empty();
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}
}