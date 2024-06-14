import java.util.ArrayList;
import java.util.List;
public class Account {
    private String accountNumber;
    private double balance;
    private List<Object> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        this.balance += amount;
        transactionHistory.add(new Deposit(accountNumber, amount));
    }

    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            transactionHistory.add(new Withdraw(accountNumber, amount));
        } else {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add(new Transfer(accountNumber, targetAccount.getAccountNumber(), amount));
        } else {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
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
