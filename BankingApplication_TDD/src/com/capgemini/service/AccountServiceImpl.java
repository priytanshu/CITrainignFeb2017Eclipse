package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientIntialAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	Account account;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		account = new Account();
	}

	@Override
	public Account createAccount(int accountNumnber, int amount) throws InsufficientIntialAmountException {
		if (amount < 500) {
			throw new InsufficientIntialAmountException();
		}

		account.setAccoutnNumber(accountNumnber);
		account.setAmount(amount);

		if (accountRepository.save(account))
			return account;
		return null;
	}

	@Override
	public int depositAmount(int accoutNumber, int amount) throws InvalidAccountNumberException {
		if (account.getAccountNumber() == accoutNumber) {
			int newAmount = account.getAmount() + amount;
			account.setAmount(newAmount);
		}
		return account.getAmount();
	}

	@Override
	public int withdraAmount(int accoutNumber, int amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
