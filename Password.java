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
        User user = bank.findUserByID(userID);
        if (user != null && user.login(oldPassword)) {
            user.setPassword(newPassword);
        }
    }

    public void findPassword(Bank bank) {
        User user = bank.findUserByID(userID);
        if (user != null && user.getPhoneNumber().equals(phoneNumber)) {
            System.out.println("비밀번호는 " + user.getPassword() + "입니다.");
        }
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
