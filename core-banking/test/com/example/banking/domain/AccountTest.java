package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void createAccount() {
		// 1. fixture
		// 2. call exercise method
		Account account = new Account("tr1", 10_000);
		// 3. verification
		assertEquals("tr1", account.getIban());
		assertEquals(10_000, account.getBalance());
		// 4. destroy test
	}
	
	@Test
	void withdrawNegativeAmount_then_fails() {
		Account account = new Account("tr1", 10_000);
		var e = assertThrows(
			IllegalArgumentException.class, 
			() -> account.withdraw(-1) 
		);
		assertEquals(10_000, account.getBalance());
		assertEquals("Amount cannot be negative.", e.getMessage());
	}

}
