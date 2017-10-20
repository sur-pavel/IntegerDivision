package ru.surpavel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        LongDivide longDivide = new LongDivide(dividend, divisor);

        System.out.println("Quotient: " + longDivide.returnResult());

    }
}
