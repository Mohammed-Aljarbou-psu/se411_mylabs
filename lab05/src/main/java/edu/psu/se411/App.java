package edu.psu.se411;

import edu.psu.se411.exceptions.InsufficientFundsException;
import edu.psu.se411.exceptions.InvalidAgeException;
import edu.psu.se411.model.Wallet;

public class App {

	// Throws InvalidAgeException for ages under 18, otherwise prints a valid message.
	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Age " + age + " is invalid: must be 18 or older.");
		}
		System.out.println("Age valid message.");
	}

	public static void main(String[] args) {
		// Exercise 1: custom exception
		try {
			validateAge(15);
		} catch (InvalidAgeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

		try {
			validateAge(21);
		} catch (InvalidAgeException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

		// Exercise 2: online wallet
		Wallet wallet = new Wallet(100);
		try {
			wallet.withdraw(250);
		} catch (InsufficientFundsException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

		try {
			wallet.withdraw(50);
			System.out.println("Withdrawal successful. Remaining balance: " + wallet.getBalance());
		} catch (InsufficientFundsException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
