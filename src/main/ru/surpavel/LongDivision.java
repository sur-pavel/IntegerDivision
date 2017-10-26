package ru.surpavel;

import java.util.Collections;

public class LongDivision {

    private static final String SPACE = " ";
    private static final String MINUS = "_";
    private static final String HYPHEN = "-";
    private static final String PIPE = "|";

    private int dividend;
    private int divisor;
    private int quotient;
    private int[] dividendDigits;
    private int minuendCalculationIndex;

    public LongDivision(int dividend, int divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be 0");
        }
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = dividend / divisor;
        this.dividendDigits = extractDigitsOfNumber(dividend);
    }

    public String createDivision() {
        StringBuilder division = new StringBuilder();
        String firstLine = MINUS + dividend + PIPE + divisor + "\n";
        division.append(firstLine);
        formRemainingLines(division);
        return division.toString();
    }

    private void formRemainingLines(StringBuilder division) {
        int subtrahend = 0;
        int minuend = 0;
        String spaces = SPACE;
        for (int currentIndex = 0; currentIndex < dividendDigits.length; currentIndex++) {
            if (currentIndex != 0) {
                spaces += repeatString(SPACE, getLength(subtrahend) - getLength(minuend));
                if (minuend == 0) {
                    spaces += SPACE;
                }
            }
            minuend = calculateMinuend(minuend, currentIndex);
            String minuendLine = repeatString(SPACE, spaces.length() - 1) + MINUS + minuend + "\n";

            subtrahend = (minuend / divisor) * divisor;
            spaces += repeatString(SPACE, getLength(minuend) - getLength(subtrahend));
            String subtrahendLine = spaces + subtrahend + "\n";
            String lineUnderSubtrahend = spaces + repeatString(HYPHEN, getLength(subtrahend)) + "\n";
            if (minuend == 0) {
                subtrahendLine = "";
                minuendLine = minuendLine.replace('_', ' ');
            }
            if (currentIndex == 0) {
                minuendLine = "";
                String spacesToQuotient = repeatString(SPACE, getLength(dividend) - getLength(minuend));
                subtrahendLine = spaces + subtrahend + spacesToQuotient + PIPE + quotient + "\n";
            }
            division.append(minuendLine).append(subtrahendLine).append(lineUnderSubtrahend);
            currentIndex = minuendCalculationIndex;
            minuend = minuend - subtrahend;
        }
    }

    private int calculateMinuend(int minuend, int currentIndex) {
        for (int i = currentIndex; minuend < divisor && i < dividendDigits.length; i++) {
            String minuendString = "" + minuend + dividendDigits[i];
            minuend = Integer.parseInt(minuendString);
            minuendCalculationIndex = i;
        }
        return minuend;
    }

    private String repeatString(String whatRepeat, int times) {
        return String.join("", Collections.nCopies(times, whatRepeat));
    }

    private int[] extractDigitsOfNumber(int number) {
        String numberToString = Integer.toString(number);
        int[] digitsInNumber = new int[getLength(number)];
        for (int i = 0; i < digitsInNumber.length; i++) {
            digitsInNumber[i] = numberToString.charAt(i) - '0';
        }
        return digitsInNumber;
    }

    private int getLength(int number) {
        return String.valueOf(number).length();
    }
}
