package edu.psu.se411.model;

import edu.psu.se411.exceptions.InsufficientFundsException;

public class Wallet {

	private double balance;

	public Wallet(double initialBalance) {
		if (initialBalance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative: " + initialBalance);
		}
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount: " + amount);
		}
		balance += amount;
	}

	// Withdraws money from the wallet to the user's bank account.
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount: " + amount);
		}
		if (amount > balance) {
			throw new InsufficientFundsException(
					"Cannot withdraw " + amount + ": wallet balance is only " + balance);
		}
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
