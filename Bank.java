import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;
    private List<Account> accounts;
    private List<Object> transactions;


    public Bank() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addUser(User user) {
    }

    public void addAccount(Account account) {
    }

    public void processTransaction(Object transaction) {
    }

    public void processMembership(Membership membership) {
    }

    public void managePassword(Password passwordManager) {

    }

    public void manageExchangeRate(ExchangeRate exchangeRate) {

    }

    public User findUserByID(String userID) {

    }

    public void removeUser(User user) {

    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Object> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Object> transactions) {
        this.transactions = transactions;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}
