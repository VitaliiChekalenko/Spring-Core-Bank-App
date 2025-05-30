package org.bank.app.account;

import org.bank.app.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountService {

    private final Map<Integer, Account> accountMap;
    private int idCounter;

    public AccountService() {
        this.accountMap = new HashMap<>();
        this.idCounter = 0;
    }

    public Account createAccount(User user) {
        idCounter++;
        Account account = new Account(idCounter, user.getId(), 0); // todo default amount
        accountMap.put(idCounter, account);
        return account;
    }

    public Optional<Account> findAccountById(int id) {
        return Optional.ofNullable(accountMap.get(id));
    }

    public List<Account> getAllUserAccounts(int userId) {
        return accountMap
                .values()
                .stream()
                .filter(account -> account.getUserId() == userId)
                .toList();
    }

    public void depositAccount(int accountId, int moneyToDeposit) {
        var account = findAccountById(accountId).orElseThrow(() -> new IllegalArgumentException("No such account: id=%s".formatted(accountId)));

        if (moneyToDeposit < 0) {
            throw new IllegalArgumentException("Cannot deposit not positive amount: amount=%s".formatted(moneyToDeposit));
        }

        account.setMoneyAmount(account.getMoneyAmount() + moneyToDeposit);
    }
}
