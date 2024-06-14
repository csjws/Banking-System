public class Membership {
    private String userID;
    private String password;
    private String phoneNumber;

    public Membership(String userID, String password, String phoneNumber) {
        this.userID = userID;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void execute(Bank bank) {
        User newUser = new User(userID, password, phoneNumber);
        Account newAccount = new Account(userID, 0.0); // 계좌번호를 userID로 설정
        newUser.addAccount(newAccount);
        bank.addUser(newUser);
        bank.addAccount(newAccount);
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
}
