package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Initial deposit cannot be negative.");
        }
        int accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(account);
        return account;
    }

    private int generateAccountNumber() {
        return accounts.size() + 1;
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found.");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
