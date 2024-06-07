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

    }

    // Getters and Setters
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
