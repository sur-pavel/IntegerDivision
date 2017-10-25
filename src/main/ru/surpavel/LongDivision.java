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

        int subtrahend = 0;
        int difference = 0;
        String spaces = "";
        StringBuilder divisionExpression = new StringBuilder();

        divisionExpression.append(this.dividend + "|" + this.divisor + "\n");

        for (int indexOfDigit = 0; indexOfDigit < this.dividendDigits.length; indexOfDigit++) {
            if (indexOfDigit != 0) {
                spaces += repeatSpace(countDozens(subtrahend) - countDozens(difference));
                if (difference == 0) {
                    spaces += " ";
                }
            }
            int minuend = difference;
            if (indexOfDigit == 0) {
                minuend = this.dividendDigits[indexOfDigit];
            }
            int count = 0;
            for (int n = indexOfDigit; minuend < this.divisor && n < this.dividendDigits.length; n++) {
                if (n == 0) {
                    n++;
                }
                String minuendString = "" + minuend + this.dividendDigits[n];
                minuend = Integer.parseInt(minuendString);
                count = n;
            }
            subtrahend = (minuend / this.divisor) * this.divisor;
            difference = minuend - subtrahend;

            String minuendLine = spaces + minuend + "\n";
            spaces += repeatSpace(countDozens(minuend) - countDozens(subtrahend));
            String subtrahendLine = spaces + subtrahend;

            if (indexOfDigit==0){
                minuendLine = "";
                String spacesToQuotient = repeatSpace(countDozens(this.dividend) - countDozens(minuend));
                subtrahendLine += spacesToQuotient + "|" + this.quotient;
            }
            subtrahendLine += "\n";
            if (minuend == 0) {
                subtrahendLine = "";
            }
            divisionExpression.append(minuendLine).append(subtrahendLine);
            indexOfDigit = count;
        }
        return divisionExpression.toString();
    }

    private String repeatSpace(int times) {
        return String.join("", Collections.nCopies(times, " "));
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

    private int countDozens(int number) {
        return String.valueOf(number).length();
    }


}
