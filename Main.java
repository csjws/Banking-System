public class Main {
    Bank bank = new Bank();
    BankSystem bankSystem = new BankSystem(bank);

    // 회원가입 테스트
    Register register = new Register("user1", "pass1", "010-1234-5678");
        bankSystem.registerUser(register);

    // 로그인 테스트
    boolean loginSuccess = bankSystem.login("user1", "pass1");
        System.out.println("Login Success: " + loginSuccess);

    // 계좌 생성 및 입금 테스트
    Account account = new Account("123-456-789", 1000.0);
        bank.addAccount(account);
        bankSystem.deposit(account, 500.0);
        System.out.println("Account Balance: " + account.balanceInquiry());

    // 출금 테스트
        bankSystem.withdraw(account, 200.0);
        System.out.println("Account Balance: " + account.balanceInquiry());

    // 이체 테스트
    Account targetAccount = new Account("987-654-321", 500.0);
        bank.addAccount(targetAccount);
        bankSystem.transfer(account, targetAccount, 300.0);
        System.out.println("Source Account Balance: " + account.balanceInquiry());
        System.out.println("Target Account Balance: " + targetAccount.balanceInquiry());

    // 비밀번호 변경 테스트
    PasswordManager passwordManager = new PasswordManager("user1", "pass1", "newpass1", "010-1234-5678");
        bankSystem.changePassword(passwordManager);
        bankSystem.logout();

    // 로그인 테스트 (비밀번호 변경 후)
    loginSuccess = bankSystem.login("user1", "newpass1");
        System.out.println("Login Success with new password: " + loginSuccess);

    // 시스템 종료
        bankSystem.exit();
}
