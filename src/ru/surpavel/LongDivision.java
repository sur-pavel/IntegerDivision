package ru.surpavel;

import java.util.Collections;

public class LongDivision {

    public String longDivide(int dividend, int divisor) {
        StringBuilder divisionExpression = new StringBuilder();
        int quotient = dividend / divisor;

        int[] dividendArray = intToArray(dividend);

        divisionExpression
                .append(dividend)
                .append("|").append(divisor).append("\n");

        int minuend = dividendArray[0];


        int count = 0;
        for (int i = 1; minuend < divisor && i + 1 < dividendArray.length; i++) {
            String differenceString = minuend + "" + dividendArray[i];
            minuend = Integer.parseInt(differenceString);
            count = i;
        }
        int subtrahend = (minuend / divisor) * divisor;


        String spaces = repeatSpace(countDozens(minuend) - countDozens(subtrahend));
        divisionExpression
                .append(spaces)
                .append(subtrahend)
                .append(repeatSpace(countDozens(dividend) - countDozens(minuend)))
                .append("|")
                .append(quotient)
                .append("\n");

        int difference = minuend - subtrahend;

        System.out.println("Minuend: " + minuend + ". Subtrahend: " + subtrahend + ". Difference: " + difference);
        for (int i = count + 1; i < dividendArray.length; i++) {


            spaces = spaces + repeatSpace(countDozens(subtrahend) - countDozens(difference));

            if (difference == 0){
                spaces = spaces + " ";
            }

            minuend = difference;
            for (int n = i; minuend < divisor && n < dividendArray.length; n++) {
                String minuendString = minuend + "" + dividendArray[n];
                minuend = Integer.parseInt(minuendString);
                i = n;
            }

            subtrahend = (minuend / divisor) * divisor;
            difference = minuend - subtrahend;

            divisionExpression
                    .append(spaces).append(minuend).append("\n");

            spaces = spaces + repeatSpace(countDozens(minuend) - countDozens(subtrahend));

            divisionExpression
                    .append(spaces).append(subtrahend).append("\n");

            System.out.println("Minuend: " + minuend + ". Subtrahend: " + subtrahend + ". Difference: " + difference);

        }


        return divisionExpression.toString();

    }

    private String repeatSpace(int times) {
        return String.join("", Collections.nCopies(times, " "));
    }

    private int[] intToArray(int number) {
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
