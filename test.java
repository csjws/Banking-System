public class test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankSystem bankSystem = new BankSystem(bank);
        bankSystem.start();
    }
}
