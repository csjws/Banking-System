

public class Withdraw {
    private String withdrawID;
    private double amount;

    public Withdraw(String accountNumber, double amount) {
        this.amount = amount;
    }

    public void execute(Account account, double amount) {
        account.withdraw(amount);
    }

    public String getWithdrawID() {
        return withdrawID;
    }

    public void setWithdrawID(String withdrawID) {
        this.withdrawID = withdrawID;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
