package ru.surpavel;

public class LongDivision {

    int dividend;
    int divisor;

    public LongDivision(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;

    }

    public void longDivide(int dividend, int divisor){
        System.out.println(dividend + " | " + divisor);
        int reminder = dividend%divisor;
        while (reminder > 0){
            int quotient = dividend/divisor;
            System.out.println("-");
            System.out.println("-\n" + quotient*divisor);
        }
    }
}
