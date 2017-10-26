package ru.surpavel;

import java.util.Collections;

public class LongDivision {

    private int dividend;
    private int divisor;
    private int quotient;
    private int[] dividendDigits;

    public LongDivision(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = dividend / divisor;
        this.dividendDigits = extractDigitsOfNumber(dividend);
    }

    public String longDivide() {

        StringBuilder divisionExpression = new StringBuilder();
        divisionExpression.append("_" + this.dividend + "|" + this.divisor + "\n" + repeatString(" ", getLength(dividend) + 2) + repeatString("¯", getLength(divisor)) + "\n");

        int subtrahend = 0;
        int minuend;
        int difference = 0;
        String spaces = " ";
        for (int currentIndex = 0; currentIndex < this.dividendDigits.length; currentIndex++) {
            int count = currentIndex;
            if (currentIndex != 0) {
                spaces += repeatString(" ", getLength(subtrahend) - getLength(difference));
                if (difference == 0) {
                    spaces += " ";
                }
            }
            if (currentIndex == 0) {
                minuend = this.dividendDigits[0];
            } else {
                minuend = difference;
            }
            for (int n = currentIndex; minuend < this.divisor && n < this.dividendDigits.length; n++) {
                if (n == 0) {
                    n++;
                }
                String minuendString = "" + minuend + this.dividendDigits[n];
                minuend = Integer.parseInt(minuendString);
                count = n;
            }
            subtrahend = (minuend / this.divisor) * this.divisor;
            difference = minuend - subtrahend;

            String minuendLine = repeatString(" ", spaces.length() - 1) + "_" + minuend + "\n";

            spaces += repeatString(" ", getLength(minuend) - getLength(subtrahend));
            String subtrahendLine = spaces + subtrahend;

            if (currentIndex == 0) {
                minuendLine = "";
                String spacesToQuotient = repeatString(" ", getLength(this.dividend) - getLength(minuend));
                subtrahendLine += spacesToQuotient + "|" + this.quotient;
            }
            subtrahendLine += "\n";
            if (minuend == 0) {
                subtrahendLine = "";
                minuendLine = minuendLine.replace('_', ' ');
            }
            String underline = spaces + repeatString("¯", getLength(subtrahend)) + "\n";
            divisionExpression.append(minuendLine).append(subtrahendLine).append(underline);
            currentIndex = count;
        }
        return divisionExpression.toString();
    }

    private String repeatString(String whatRepeat, int times) {
        return String.join("", Collections.nCopies(times, whatRepeat));
    }

    private int[] extractDigitsOfNumber(int number) {
        String temp = Integer.toString(number);
        int arraySize = temp.length();
        int[] digitsInNumber = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            digitsInNumber[i] = temp.charAt(i) - '0';
        }
        return digitsInNumber;
    }

    private int getLength(int number) {
        return String.valueOf(number).length();
    }


}
