package org.bank.app.user;

import org.bank.app.account.AccountService;

import java.util.*;

public class UserService {

    private final Map<Integer, User> userMap;
    private int idCounter;
    private Set<String> takenLogins;
    private final AccountService accountService;

    public UserService(AccountService accountService) {
        this.accountService = accountService;
        this.takenLogins = new HashSet<>();
        this.userMap = new HashMap<>();
        this.idCounter = 0;
    }

    public User createUser(String login) {

        if (takenLogins.contains(login)) {
            throw new IllegalArgumentException("User already exists with login=%s".formatted(login));
        }

        takenLogins.add(login);
        idCounter++;
        User newUser = new User(idCounter, login, new ArrayList<>());
        var newAccount = accountService.createAccount(newUser);

        newUser.getAccountList().add(newAccount);
        userMap.put(newUser.getId(), newUser);
        return newUser;

    }

    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }
}
