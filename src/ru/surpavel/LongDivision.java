package ru.surpavel;

import java.util.Collections;

public class LongDivision {

    public void longDivide(int dividend, int divisor) {
        int quotient = dividend / divisor;
        int[] quotientArray = intToArray(quotient);
        int[] dividendArray = intToArray(dividend);

        System.out.println("_" + dividend + "|" + divisor);

        StringBuilder stringBuilder = new StringBuilder();
        int spacesRepeatTimes = Integer.toString(dividend).length() - Integer.toString(divisor).length();
        stringBuilder.append(" ").append(divisor).append(repeatString(" ", spacesRepeatTimes)).append("|")
                .append(quotient);
        System.out.println(stringBuilder.toString());

        for (int i = 1; i < quotientArray.length; i++) {
            int divisorMultiply = divisor * quotientArray[i];


            int localQuotient = (dividend / (int) Math.pow(10, countDozens(dividend))) - divisor * quotientArray[i-1];

            stringBuilder = new StringBuilder();
            stringBuilder.append(repeatString(" ", i)).append("_").append(Integer.toString(localQuotient) + dividendArray[i]).append("\n")
                    .append(repeatString(" ", i + 1)).append(divisorMultiply);
            System.out.println(stringBuilder.toString());

        }

    }

    private String repeatString(String stringToRepeat, int times) {
        return String.join("", Collections.nCopies(times, stringToRepeat));
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
        return String.valueOf(number).length() - 1;
    }


}
