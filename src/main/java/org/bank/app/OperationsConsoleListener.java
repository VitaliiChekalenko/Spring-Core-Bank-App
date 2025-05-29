package org.bank.app;

import java.util.Scanner;

public class OperationsConsoleListener {

private Scanner scanner;

    public OperationsConsoleListener(Scanner scanner) {
        this.scanner = scanner;
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
