

public class Deposit {
    private String depositID;
    private double amount;

    public Deposit(String accountNumber, double amount) {

    }

    public void execute(Account account, double amount) {


    }
    public String getDepositID() {
        return depositID;
    }

    public void setDepositID(String depositID) {
        this.depositID = depositID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
