package ru.surpavel;

public class LongDivide {
    private int dividend;
    private int divisor;
    private int n;
    private StringBuffer dividendSB;
    private StringBuffer quotient = new StringBuffer("");
    private StringBuffer firstSplitedString;
    private StringBuffer secondSplitedString;
    public StringBuffer divisionExpression = new StringBuffer("");


    public LongDivide(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        quotient = new StringBuffer("");
        this.dividendSB = new StringBuffer(Integer.toString(this.dividend));
    }

    public void repeatAddToExpression(String s, int n) {
        for (int i = 0; i < n; i++) {
            divisionExpression.append(s);
        }
    }

    public StringBuffer returnResult() {

//    First two lines of long division
        divisionExpression.append(dividendSB + "|" + divisor + "\n");
        repeatAddToExpression(" ", dividendSB.length());
        repeatAddToExpression("-", Integer.toString(divisor).length() + 1);

//    Remaining lines of long division
        StringBuffer t = new StringBuffer("");
        for (int i = 0; this.dividend >= this.divisor; i++) {
            divisionExpression.append("\n" + t.toString() + this.getLeftDividendNumber());
            count();
            divisionExpression.append("\n" + t.toString() + n * divisor);
            t.append(" ");
        }

        calculateResult();
        return quotient;
    }

    private void calculateResult() {
        if (this.dividend != 0)
            quotient.append(".");

        for (int numberOfDigits = 5; this.dividend != 0 && numberOfDigits != 0; numberOfDigits--) {
            for (int i = 0; dividend < divisor; i++) {
                dividend = Integer.parseInt(dividendSB.append("0").toString());
                if (i > 0) {
                    quotient.append("0");
                }
            }
            count();
        }
    }

    public int getLeftDividendNumber() {
        int i = 1;
        while (Integer.parseInt(Integer.toString(this.dividend).substring(0, i)) < this.divisor) {
            i++;
        }
        this.firstSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(0, i));
        this.secondSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(i, Integer.toString(this.dividend).length()));
        return Integer.parseInt(this.firstSplitedString.toString());
    }

    public void count() {
        this.n = this.getLeftDividendNumber() / divisor;
        quotient.append(n);
        this.dividendSB = new StringBuffer(Integer.toString(this.getLeftDividendNumber() % divisor));
        this.dividendSB.append(this.secondSplitedString);
        dividend = Integer.parseInt(this.dividendSB.toString());
    }
}