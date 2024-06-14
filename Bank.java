import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;
    private List<Account> accounts;
    private List<Object> transactions;
    private List<ExchangeRate> exchangeRates;

    public Bank() {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.exchangeRates = new ArrayList<>();
        this.exchangeRates.add(new ExchangeRate("미국", 1384.50));
        this.exchangeRates.add(new ExchangeRate("일본", 8.80));
        this.exchangeRates.add(new ExchangeRate("중국", 190.41));
        this.exchangeRates.add(new ExchangeRate("유럽연합", 1481.83));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void processTransaction(Object transaction) {
        transactions.add(transaction);
    }

    public void processMembership(Membership Membership) {
        Membership.execute(this);
    }

    public void manageExchangeRate(ExchangeRate exchangeRate) {
        exchangeRates.add(exchangeRate);
    }

    public User findUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(User user) {
        users.remove(user);
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
