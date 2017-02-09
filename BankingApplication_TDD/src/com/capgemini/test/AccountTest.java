package com.capgemini.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exception.InsufficientIntialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;

	AccountService accountService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*
	 * create account 1.when the amount is less than 500 system should throw
	 * exception 2.when the valid info is passed account should be created
	 * successfully
	 */

	@Test(expected = com.capgemini.exception.InsufficientIntialAmountException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException()
			throws InsufficientIntialAmountException {
		accountService.createAccount(101, 400);
	}

	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientIntialAmountException {
		Account account = new Account();
		account.setAmount(101);
		account.setAmount(5000);

		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}

	@Test(expected = com.capgemini.exception.InvalidAccountNumberException.class)
	public void whenAccountNumberIsNotValidSystemThrorException() throws InvalidAccountNumberException {
		accountRepository.searchAccount(101);
	}
	
	
	
	
}
