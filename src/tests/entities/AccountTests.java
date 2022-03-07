package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	@DisplayName("Deposit Should Increase Balance When Positive Amount")
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		Double amount = 200.0;
		Double expectedValue = 196.0;		
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	
		
	}
	
	@Test
	@DisplayName("Deposit Should Do Nothing When Negative Amount")
	public void depositShouldDoNothingWhenNegativeAmount() {
		Double expectedValue = 100.0;		
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	@DisplayName("Full Whitedraw should clear balance")
	public void fullWhitedrawShouldClearBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		Assertions.assertEquals(expectedValue, result);		
		
	}
	
	@Test
	@DisplayName("Withdraw should decrease balance when sufficient balance")
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		double initializeBalance = 800.0;
		double expected = 300.0;
		Account acc = AccountFactory.createAccount(initializeBalance);
		
		acc.withdraw(500.0);
		
		Assertions.assertEquals(expected, acc.getBalance() );
	}
	
	@Test
	@DisplayName("Withdraw should throw exception when insufficient balance")
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		
		Assertions.assertThrows(IllegalArgumentException.class,() -> {
					double initializeBalance = 800.0;		
					Account acc = AccountFactory.createAccount(initializeBalance);
					
					acc.withdraw(800.2);
				});
	}
	
	
}
