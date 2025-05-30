package org.bank.app;

import org.bank.app.account.AccountService;
import org.bank.app.user.UserService;

import java.util.Scanner;

public class OperationsConsoleListener {

    private Scanner scanner;
    private final AccountService accountService;
    private final UserService userService;

    public OperationsConsoleListener(Scanner scanner,
                                     UserService userService,
                                     AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
        this.userService = userService;
    }

    public void listenUpdates() {

        System.out.println("Please type operations:\n");
        while (true) {
            String nextOperation = scanner.nextLine();
            System.out.println("Please type next operation:\n");

            if (nextOperation.equals("USER_CREATE")) {
                System.out.println("User created\n");
            } else if (nextOperation.equals("ACCOUNT_CREATE")) {
                System.out.println("Account created\n");
            } else {
                System.out.println("Not found operation");
            }
        }
    }
}
