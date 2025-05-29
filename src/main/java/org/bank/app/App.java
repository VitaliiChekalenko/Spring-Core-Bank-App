package org.bank.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.bank.app");
        context.getBean(OperationsConsoleListener.class).listenUpdates();
    }
}
