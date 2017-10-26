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
        String SPACE = " ";
        String MINUS = "_";
        String UNDERSCORE = "¯";

        StringBuilder divisionExpression = new StringBuilder();
        String firstLine = MINUS + this.dividend + "|" + this.divisor + "\n";
        divisionExpression
                .append(firstLine);
        int subtrahend = 0;
        int minuend;
        int difference = 0;
        String spaces = " ";
        for (int currentIndex = 0; currentIndex < this.dividendDigits.length; currentIndex++) {
            int count = currentIndex;
            if (currentIndex != 0) {
                spaces += repeatString(SPACE, getLength(subtrahend) - getLength(difference));
                if (difference == 0) {
                    spaces += " ";
                }
            }
            if (currentIndex == 0) {
                minuend = this.dividendDigits[0];
            } else {
                minuend = difference;
            }
            for (int i = currentIndex; minuend < this.divisor && i < this.dividendDigits.length; i++) {
                if (i == 0) {
                    i++;
                }
                String minuendString = "" + minuend + this.dividendDigits[i];
                minuend = Integer.parseInt(minuendString);
                count = i;
            }
            subtrahend = (minuend / this.divisor) * this.divisor;
            difference = minuend - subtrahend;

            String minuendLine = repeatString(SPACE, spaces.length() - 1) + MINUS + minuend + "\n";

            spaces += repeatString(SPACE, getLength(minuend) - getLength(subtrahend));
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
            String underline = spaces + repeatString(UNDERSCORE, getLength(subtrahend)) + "\n";
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
