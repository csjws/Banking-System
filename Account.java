import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Object> transactionHistory;

    public Account(String accountNumber, double initialBalance) {

    }

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    public void transfer(Account targetAccount, double amount) {

    }

    public double balanceInquiry() {
        return this.balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Object> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Object> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
