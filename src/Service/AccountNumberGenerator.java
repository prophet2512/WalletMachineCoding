package Service;

public class AccountNumberGenerator {

    private static int accountNumberSequence = 1;
    public static int generateAccountNumber() {
        return accountNumberSequence++;
    }
}
