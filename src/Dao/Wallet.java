package Dao;

import Entities.Account;

import java.util.HashMap;
import java.util.Map;

public class Wallet {
    Map<Integer, Account> accounts;

    public Wallet() {
        this.accounts = new HashMap<>();
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
