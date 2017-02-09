package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientIntialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {
	Account createAccount(int accountNumnber, int amount) throws InsufficientIntialAmountException;

	int depositAmount(int accoutNumber, int amount) throws InvalidAccountNumberException;

	int withdraAmount(int accoutNumber, int amount) throws InsufficientBalanceException;
}
