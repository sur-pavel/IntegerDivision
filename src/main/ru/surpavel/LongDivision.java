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

    public LongDivision(int dividend, int divisor) {
        if (divisor == 0) {
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

    private class DivisionData {
        int minuend;
        int subtrahend;
        StringBuilder indentation;

        DivisionData(int minuend, int subtrahend, StringBuilder indentation) {
            this.minuend = minuend;
            this.subtrahend = subtrahend;
            this.indentation = indentation;
        }
    }

    private void formRemainingLines(StringBuilder division) {
        DivisionData divisionData = new DivisionData(0, 0, new StringBuilder(SPACE));
        for (int currentIndex = 0; currentIndex < dividendDigits.length; currentIndex++) {
            int indexAfterCalculation = calculateMinuendAndSubtrahend(currentIndex, divisionData);
            String nextLines = createNextLines(currentIndex, divisionData);
            division.append(nextLines);
            divisionData.minuend = divisionData.minuend - divisionData.subtrahend;
            currentIndex = indexAfterCalculation;
            increaseIndentation(divisionData);
        }
    }

    private String createNextLines(int currentIndex, DivisionData divisionData) {
        String minuendLine = divisionData.indentation.substring(1) + MINUS + divisionData.minuend + "\n";
        String indentBeforeSubtrahend = repeatString(SPACE,
                getLength(divisionData.minuend) - getLength(divisionData.subtrahend));
        divisionData.indentation.append(indentBeforeSubtrahend);
        String subtrahendLine = divisionData.indentation.toString() + divisionData.subtrahend;
        if (currentIndex == 0) {
            minuendLine = "";
            String indentBeforeQuotient = repeatString(SPACE, getLength(dividend) - getLength(divisionData.minuend));
            subtrahendLine += indentBeforeQuotient + PIPE + quotient + "\n";
        } else {
            if (divisionData.minuend == 0) {
                minuendLine = minuendLine.replace(MINUS, " ");
                subtrahendLine = "";
            } else {
                subtrahendLine += "\n";
            }
        }
        String separationLine = divisionData.indentation + repeatString(HYPHEN, getLength(divisionData.subtrahend))
                + "\n";
        return minuendLine + subtrahendLine + separationLine;
    }

    private void increaseIndentation(DivisionData divisionData) {
        divisionData.indentation
                .append(repeatString(SPACE, getLength(divisionData.subtrahend) - getLength(divisionData.minuend)));
        if (divisionData.minuend == 0) {
            divisionData.indentation.append(SPACE);
        }
    }

    private int calculateMinuendAndSubtrahend(int currentIndex, DivisionData divisionData) {
        int minuendCalculationIndex = 0;
        for (int i = currentIndex; divisionData.minuend < divisor && i < dividendDigits.length; i++) {
            String minuendString = "" + divisionData.minuend + dividendDigits[i];
            divisionData.minuend = Integer.parseInt(minuendString);
            minuendCalculationIndex = i;
        }
        divisionData.subtrahend = (divisionData.minuend / divisor) * divisor;
        return minuendCalculationIndex;
    }

    private String repeatString(String whatRepeat, int times) {
        return String.join("", Collections.nCopies(times, whatRepeat));
    }

    private int getLength(int number) {
        return String.valueOf(number).length();
    }

    private int[] extractDigitsOfNumber(int number) {
        String numberToString = Integer.toString(number);
        int[] digitsInNumber = new int[getLength(number)];
        for (int i = 0; i < digitsInNumber.length; i++) {
            digitsInNumber[i] = numberToString.charAt(i) - '0';
        }
        return digitsInNumber;
    }
}
