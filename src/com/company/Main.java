package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prosím zadej hrubou mzdu: ");
        int grossWage = Integer.parseInt(scanner.nextLine());
        System.out.println("Prosím zadej celkovou čast zaloh: ");
        int advance = Integer.parseInt(scanner.nextLine());
        System.out.println("Prosím vyber zda-li jsi student (true/false): ");
        boolean student = scanner.nextBoolean();

        SalaryManager.GetSalaryDetails(grossWage, advance, student);
    }
}
