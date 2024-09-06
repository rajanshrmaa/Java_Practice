package com.designpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Aggregate Interface
interface AccountContainer {
    Iterator<Account> getIterator();
}

// Concrete Aggregate
class Bank implements AccountContainer {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) {
        // Check for duplicate account number
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(account.getAccountNumber())) {
                return false; // Duplicate found
            }
        }
        accounts.add(account);
        return true; // Account added successfully
    }

    @Override
    public Iterator<Account> getIterator() {
        return new AccountIterator();
    }

    private class AccountIterator implements Iterator<Account> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < accounts.size();
        }

        @Override
        public Account next() {
            return hasNext() ? accounts.get(index++) : null;
        }
    }
}

// Entity Class
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

// Main class
public class IteratorDesignPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Enter number of accounts:");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Enter account number:");
            String accountNumber = scanner.nextLine();
            System.out.println("Enter account balance:");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Account account = new Account(accountNumber, balance);
            if (bank.addAccount(account)) {
                System.out.println("Account added successfully.");
            } else {
                System.out.println("Error: Account number " + accountNumber + " already exists.");
            }
        }

        System.out.println("Accounts in the bank:");
        Iterator<Account> iterator = bank.getIterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
        }

        scanner.close();
    }
}
