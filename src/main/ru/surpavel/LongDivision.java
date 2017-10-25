package ru.surpavel;

import java.util.Collections;

public class LongDivision {

    public String longDivide(int dividend, int divisor) {

        StringBuilder divisionExpression = new StringBuilder();
        int quotient = dividend / divisor;
        int[] dividendDigits = extractDigitsOfNumber(dividend);

        String firstLineOfExpression = dividend + "|" + divisor + "\n";

// Second line
        int minuend = dividendDigits[0];
        int count = 0;
        for (int i = 1; minuend < divisor && i + 1 < dividendDigits.length; i++) {
            String differenceString = minuend + "" + dividendDigits[i];
            minuend = Integer.parseInt(differenceString);
            count = i;
        }
        int subtrahend = (minuend / divisor) * divisor;


        String spaces = repeatSpace(countDozens(minuend) - countDozens(subtrahend));
        String spacesToQuotient = repeatSpace(countDozens(dividend) - countDozens(minuend));
        String secondLineOfExpression = spaces + subtrahend + spacesToQuotient + "|" + quotient + "\n";
        divisionExpression.append(secondLineOfExpression);

        int difference = minuend - subtrahend;

// Remained lines
        for (int i = count + 1; i < dividendDigits.length; i++) {

            spaces = spaces + repeatSpace(countDozens(subtrahend) - countDozens(difference));

            if (difference == 0) {
                spaces += " ";
            }

            minuend = difference;

            for (int n = i; minuend < divisor && n < dividendDigits.length; n++) {
                String minuendString = "" + minuend + dividendDigits[n];
                minuend = Integer.parseInt(minuendString);
                i = n;
            }

            subtrahend = (minuend / divisor) * divisor;
            difference = minuend - subtrahend;

            String minuendLine = spaces + minuend + "\n";

            spaces += repeatSpace(countDozens(minuend) - countDozens(subtrahend));


            String subtrahendLine = spaces + subtrahend + "\n";
            if (minuend == 0) {
                subtrahendLine = "";
            }

            System.out.println("Minuend: " + minuend + ". Subtrahend: " + subtrahend + ". Difference: " + difference);

            divisionExpression.append(minuendLine).append(subtrahendLine);
        }

        return firstLineOfExpression + divisionExpression.toString();

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
