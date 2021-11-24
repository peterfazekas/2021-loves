package hu.targetshooting.model.service;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readId() {
        return scanner.nextInt();
    }
}
