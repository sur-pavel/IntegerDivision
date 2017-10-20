package ru.surpavel;

public class LongDivide {
    private int dividend;
    private int divider;
    private int n;
    private StringBuffer dividendSB;
    private StringBuffer result = new StringBuffer("");
    private StringBuffer firstSplitedString;
    private StringBuffer secondSplitedString;
    private StringBuffer print = new StringBuffer("");


    public LongDivide(int dividend, int divisor) {
        this.dividend = dividend;
        this.divider = divisor;
        result = new StringBuffer("");
        this.dividendSB = new StringBuffer(Integer.toString(this.dividend));
    }

    public void printSomeCharSomeTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            print.append(s);
        }
    }

    public StringBuffer returnResult() {
        print.append(dividendSB + "|" + divider + "\n");

        printSomeCharSomeTimes(" ", dividendSB.length());
        printSomeCharSomeTimes("-", Integer.toString(divider).length() + 1);
        StringBuffer t = new StringBuffer("");
        for (int i = 0; this.dividend >= this.divider; i++) {
            print.append("\n" + t.toString() + this.getLeftDividendNumber());
            count();
            print.append("\n" + t.toString() + n * divider);
            t.append(" ");
        }

        if (this.dividend != 0)
            result.append(".");

        int numberOfDigits = 5;

        while (this.dividend != 0 && numberOfDigits != 0) {
            for (int i = 0; dividend < divider; i++) {
                dividend = Integer.parseInt(dividendSB.append("0").toString());
                if (i > 0) {
                    result.append("0");
                }
            }
            count();
            numberOfDigits--;
        }
        return result;
    }

    public int getLeftDividendNumber() {
        int i = 1;
        while (Integer.parseInt(Integer.toString(this.dividend).substring(0, i)) < this.divider) {
            i++;
        }
        this.firstSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(0, i));
        this.secondSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(i, Integer.toString(this.dividend).length()));
        return Integer.parseInt(this.firstSplitedString.toString());
    }

    public void count() {
        this.n = this.getLeftDividendNumber() / divider;
        result.append(n);
        this.dividendSB = new StringBuffer(Integer.toString(this.getLeftDividendNumber() % divider));
        this.dividendSB.append(this.secondSplitedString);
        dividend = Integer.parseInt(this.dividendSB.toString());
    }
}