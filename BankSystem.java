import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class BankSystem {
    private User currentUser;
    private Bank bank;

    public BankSystem(Bank bank) {
        this.bank = bank;
    }

    public boolean login(String userID, String password) {
        User user = bank.findUserByID(userID);
        if (user != null && user.login(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public void MembershipUser(Membership membership) {
        bank.processMembership(membership);
    }

    public void findPassword(Password passwordManager) {
        passwordManager.findPassword(bank);
    }

    public void changePassword(Password passwordManager) {
        passwordManager.changePassword(bank);
    }

    public void deleteUser(String userID) {
        if (currentUser != null && currentUser.getUserID().equals(userID)) {
            currentUser.deleteAccount(bank);
            logout();
        }
    }

    public void deposit(double amount) {
        if (currentUser != null) {
            Account account = currentUser.getAccount();
            if (account != null) {
                account.deposit(amount);
                bank.processTransaction(new Deposit(account.getAccountNumber(), amount));
            }
        }
    }

    public void withdraw(double amount) {
        if (currentUser != null) {
            Account account = currentUser.getAccount();
            if (account != null) {
                try {
                    account.withdraw(amount);
                    bank.processTransaction(new Withdraw(account.getAccountNumber(), amount));
                    System.out.println("출금 완료!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void transfer(String targetUserID, double amount) {
        if (currentUser != null) {
            Account sourceAccount = currentUser.getAccount();
            User targetUser = bank.findUserByID(targetUserID);
            if (targetUser == null) {
                System.out.println("계좌이체 할 계좌번호가 잘못되었습니다.");
                return;
            }
            if (sourceAccount != null && targetUser != null) {
                Account targetAccount = targetUser.getAccount();
                try {
                    sourceAccount.transfer(targetAccount, amount);
                    bank.processTransaction(new Transfer(sourceAccount.getAccountNumber(), targetAccount.getAccountNumber(), amount));
                    System.out.println("계좌이체 완료!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }else {
                System.out.println("계좌이체 할 계좌번호가 잘못되었습니다.");
            }
        }
    }

    public double balanceInquiry() {
        if (currentUser != null) {
            Account account = currentUser.getAccount();
            if (account != null) {
                return account.balanceInquiry();
            }
        }
        return 0.0;
    }

    public void showExchangeRates() {
        List<ExchangeRate> rates = bank.getExchangeRates();
        for (ExchangeRate rate : rates) {
            System.out.println(rate.getCurrencyPair() + " : " + rate.getRate() + "원");
        }
    }

    public void exit() {
        // 시스템 종료
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentUser == null) {
                System.out.println("==========================================");
                System.out.println("원하시는 작업의 번호를 입력해주세요");
                System.out.println("==========================================");
                System.out.println("1. 로그인     2.회원가입     3. 비밀번호찾기");
                System.out.print("입력 : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("<<로그인>>");
                        System.out.print("ID : ");
                        String userID = scanner.nextLine();
                        System.out.print("password : ");
                        String password = scanner.nextLine();
                        if (login(userID, password)) {
                            System.out.println("로그인 성공");
                        } else {
                            System.out.println("ID나 password가 입력이 잘못되었거나 회원이 아닙니다.");
                        }
                        break;
                    case 2:
                        System.out.println("<<회원가입>>");
                        System.out.print("회원가입을 진행 하겠습니까?(y/n) : ");
                        String manswer = scanner.nextLine();
                        if(manswer.equals("n")){
                            break;
                        }
                        System.out.print("ID : ");
                        String newUserID = scanner.nextLine();
                        System.out.print("Password : ");
                        String newPassword = scanner.nextLine();
                        System.out.print("전화번호(숫자만) : ");
                        String phoneNumber = scanner.nextLine();
                        Membership register = new Membership(newUserID, newPassword, phoneNumber);
                        MembershipUser(register);
                        System.out.println("회원가입 성공");
                        break;
                    case 3:
                        System.out.println("<<비밀번호찾기>>");
                        System.out.print("ID: ");
                        String findUserID = scanner.nextLine();
                        System.out.print("전화번호(숫자만) : ");
                        String findPhoneNumber = scanner.nextLine();
                        Password findPasswordManager = new Password(findUserID, "", "", findPhoneNumber);
                        findPassword(findPasswordManager);
                        break;
                    default:
                        System.out.println("잘못된 옵션입니다.");
                }
            } else {
                System.out.println("<<Bank System>>");
                System.out.println("==========================================");
                System.out.println("원하시는 작업의 번호를 입력해주세요");
                System.out.println("==========================================");
                System.out.println("1. 로그아웃     2. 회원탈퇴     3. 비밀번호변경");
                System.out.println("4. 입금하기     5. 출금하기     6. 계좌이체하기");
                System.out.println("7. 잔액조회     8. 환율조회     9. 종료");
                System.out.print("입력 : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("로그아웃 하시겠습니까?(y/n) : ");
                        String loanswer = scanner.nextLine();
                        if(loanswer.equals("n")){
                            break;
                        }
                        logout();
                        System.out.println("로그아웃");
                        break;
                    case 2:
                        System.out.println("<<회원탈퇴>>");
                        System.out.print("회원을 탈퇴하시겠습니까?(y/n) : ");
                        String mwanswer = scanner.nextLine();
                        if(mwanswer.equals("n")){
                            break;
                        }
                        deleteUser(currentUser.getUserID());
                        System.out.println("회원탈퇴 완료!");
                        break;
                    case 3:
                        System.out.println("<<비밀번호변경>>");
                        System.out.print("비밀번호를 변경하시겠습니까?(y/n) : ");
                        String cpanswer = scanner.nextLine();
                        if(cpanswer.equals("n")){
                            break;
                        }
                        System.out.print("변경할 비밀번호 : ");
                        String newPassword = scanner.nextLine();
                        Password changePasswordManager = new Password(currentUser.getUserID(), currentUser.getPassword(), newPassword, currentUser.getPhoneNumber());
                        changePassword(changePasswordManager);
                        System.out.println("변경 완료!");
                        break;
                    case 4:
                        System.out.println("<<입금하기>>");
                        System.out.print("입금하기를 진행 하겠습니까?(y/n) : ");
                        String answer = scanner.nextLine();
                        if(answer.equals("n")){
                            break;
                        }
                        System.out.print("입금금액 : ");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        System.out.println("입금 완료!");
                        break;
                    case 5:
                        System.out.println("<<출금하기>>");
                        System.out.print("출금하기를 진행 하겠습니까?(y/n) : ");
                        String wanswer = scanner.nextLine();
                        if(wanswer.equals("n")){
                            break;
                        }
                        System.out.print("출금금액: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 6:
                        System.out.println("<<계좌이체하기>>");
                        System.out.print("회원가입을 진행 하겠습니까?(y/n) : ");
                        String tanswer = scanner.nextLine();
                        if(tanswer.equals("n")){
                            break;
                        }
                        System.out.print("계좌번호 : ");
                        String targetUserID = scanner.nextLine();
                        System.out.print("계좌이체금액 : ");
                        double transferAmount = scanner.nextDouble();
                        transfer(targetUserID, transferAmount);
                        break;
                    case 7:
                        System.out.println("<<잔액조회>>");
                        System.out.print("잔액조회를 진행 하겠습니까?(y/n) : ");
                        String banswer = scanner.nextLine();
                        if(banswer.equals("n")){
                            break;
                        }
                        double balance = balanceInquiry();
                        System.out.println("보유 잔액: " + balance);
                        break;
                    case 8:
                        System.out.println("<<환율>>");
                        System.out.print("비밀번호를 변경하시겠습니까?(y/n) : ");
                        String eranswer = scanner.nextLine();
                        if(eranswer.equals("n")){
                            break;
                        }
                        showExchangeRates();
                        break;
                    case 9:
                        System.out.println("<<Exit>>");
                        System.out.print("Exit 하시겠습니까?(y/n) : ");
                        String eanswer = scanner.nextLine();
                        if(eanswer.equals("n")){
                            break;
                        }
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("잘못된 옵션입니다.");
                }
            }
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
