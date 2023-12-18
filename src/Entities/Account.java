package Entities;

import Service.AccountNumberGenerator;

import java.math.BigDecimal;
import java.util.*;

public class Account {
    private int accountNumber;
    private User user;
    private BigDecimal balance;
    private Set<Transaction> transactionList;

    public Account(){};

    public Account(String name, BigDecimal amount){
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.user = new User(name);
        this.balance = amount;
        this.transactionList = new TreeSet<>(Comparator.comparing(Transaction::getDate));
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", user=" + user +
                ", balance=" + balance +
                ", transactionList=" + transactionList +
                '}';
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(Set<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
