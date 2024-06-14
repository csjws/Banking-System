import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String password;
    private String phoneNumber;
    private List<Account> accounts;

    public User(String userID, String password, String phoneNumber) {
        this.userID = userID;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    public boolean login(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void deleteAccount(Bank bank) {
        bank.removeUser(this);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount() {
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
