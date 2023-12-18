import Service.WalletService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WalletService walletService = new WalletService();
        Scanner sc = new Scanner(System.in);

        outer: while(true) {
            System.out.println("\nOPTIONS:");
            System.out.println("1. Create wallet");
            System.out.println("2. Transfer Amount");
            System.out.println("3. Account Statement");
            System.out.println("4. Overview");
            System.out.println("5. Exit");
            switch (sc.next()){
                case "1":
                    System.out.println("You selected to create wallet.");
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter initial amount for account: ");
                    BigDecimal balance = sc.nextBigDecimal();
                    walletService.createWallet(name, balance);
                    break;
                case "2":
                    System.out.println("You selected to transfer the amount.");
                    System.out.println("Enter source account number: ");
                    int fromAcc = sc.nextInt();
                    System.out.println("Enter the account number to which the amount needs to be transferred: ");
                    int toAcc = sc.nextInt();
                    BigDecimal amountToTransfer = sc.nextBigDecimal();
                    walletService.transferAmount(fromAcc, toAcc, amountToTransfer);
                    break;
                case "3":
                    System.out.println("You selected to view the statement of your account.");
                    System.out.println("Please enter the account number: ");
                    int accountNumber = sc.nextInt();
                    walletService.statement(accountNumber);
                    break;
                case "4":
                    System.out.println("You selected for an overview of the accounts.");
                    walletService.overview();
                    break;
                case "5":
                    System.out.println("You selected to quit the wallet. Goodbye for now.");
                    break outer;
                default:
                    System.out.println("You have selected invalid option, please retry.");
                    break;
            }
        }
        sc.close();
    }
}