package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        balance -= amount;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nBalance: ₴" + balance;
    }

}
