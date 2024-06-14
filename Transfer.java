

public class Transfer {
    private String transferID;
    private double amount;
    private String targetAccount;


    public Transfer(String sourceAccount, String targetAccount, double amount) {
        this.amount = amount;
        this.targetAccount = targetAccount;
    }

    public void execute(Account sourceAccount, Account targetAccount, double amount) {
        sourceAccount.transfer(targetAccount, amount);
    }

    public String getTransferID() {
        return transferID;
    }

    public void setTransferID(String transferID) {
        this.transferID = transferID;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }
}
