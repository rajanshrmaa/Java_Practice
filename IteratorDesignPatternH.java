package com.designpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void addAccount(Account account) {
        accounts.add(account);
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
public class IteratorDesignPatternH {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account("123456", 1500.00));
        bank.addAccount(new Account("789012", 2000.00));
        bank.addAccount(new Account("345678", 2500.00));

        Iterator<Account> iterator = bank.getIterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
        }
    }
}
