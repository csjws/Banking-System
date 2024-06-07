public class Password {
    private String userID;
    private String oldPassword;
    private String newPassword;
    private String phoneNumber;

    public Password(String userID, String oldPassword, String newPassword, String phoneNumber) {
        this.userID = userID;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.phoneNumber = phoneNumber;
    }

    public void changePassword(Bank bank) {

    }

    public void findPassword(Bank bank) {

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
