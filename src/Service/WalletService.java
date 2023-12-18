package Service;

import Dao.Wallet;
import Entities.Account;
import Entities.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class WalletService {
    private Wallet wallet;

    public WalletService() {
        this.wallet = new Wallet();
    }

    public void createWallet(String name, BigDecimal amount){
        Account account = new Account(name, amount);
        wallet.getAccounts().put(account.getAccountNumber(), account);
        System.out.printf("Account created for User:%s with account number: %d.\n", account.getUser().getName(), account.getAccountNumber());
    }

    public void transferAmount(int fromAcc, int toAcc, BigDecimal amountToTransfer) {
        if(!validateTransaction(fromAcc, toAcc, amountToTransfer))
            return;

        Transaction transaction = new Transaction(fromAcc, toAcc, amountToTransfer, new Date());
        Account fromAccount = wallet.getAccounts().get(fromAcc);
        Account toAccount = wallet.getAccounts().get(toAcc);

        fromAccount.setBalance(fromAccount.getBalance().subtract(amountToTransfer));
        toAccount.setBalance(toAccount.getBalance().add(amountToTransfer));

        fromAccount.getTransactionList().add(transaction);
        toAccount.getTransactionList().add(transaction);

        System.out.println("Transaction completed.");
    }

    public void statement(int accountNumber) {
        if(!wallet.getAccounts().containsKey(accountNumber)){
            System.out.println("Enter valid account number.");
        }
        // final because we don't want to make any mutations happening in this account.
        final Account account = wallet.getAccounts().get(accountNumber);
        System.out.printf("Account number: %d\n" +
                "Balance: %f", accountNumber, account.getBalance());
        System.out.println("Transactions: \n");
        System.out.println(account.getTransactionList());
    }

    public void overview() {
        for(int account:wallet.getAccounts().keySet()) {
            System.out.printf("Balance for account: %d is %f", account, wallet.getAccounts().get(account).getBalance());
        }
    }
    private boolean validateTransaction(int fromAcc, int toAcc, BigDecimal amountToTransfer) {
        if(fromAcc == toAcc){
            System.out.println("Accounts cannot be same for any transaction.");
            return false;
        }
        if(amountToTransfer.compareTo(new BigDecimal("0.01"))<0) {
            System.out.println("Amount should be greater than 1 Paisa.");
            return false;
        }
        if(!wallet.getAccounts().containsKey(fromAcc)||!wallet.getAccounts().containsKey(toAcc)){
            System.out.println("Please try with valid account details.");
            return false;
        }
        if(wallet.getAccounts().get(fromAcc).getBalance().compareTo(amountToTransfer)<0){
            System.out.println("Amount insufficient in account.");
            return false;
        }
        return true;
    }
}
