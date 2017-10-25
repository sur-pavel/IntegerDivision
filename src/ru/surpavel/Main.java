package ru.surpavel;

public class Main {

    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        LongDivide longDivide = new LongDivide(dividend, divisor);

        System.out.println("Quotient: " + longDivide.returnResult());
*/

        LongDivide longDivide = new LongDivide(1000, 3);
        System.out.println(longDivide.returnResult());
        System.out.println(longDivide.print.toString());


    }
}
