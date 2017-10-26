package ru.surpavel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class LongDivisionTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private LongDivision longDivision;

    @Test
    public void DivisionByZero_ThrowException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Divisor can't be 0");
        longDivision = new LongDivision(100, 0);
    }

    @Test
    public void DivisionByOneDigitNumber() {
        longDivision = new LongDivision(1000, 4);
        String expected = "_1000|4\n" +
                "  8  |250\n" +
                "  -\n" +
                " _20\n" +
                "  20\n" +
                "  --\n" +
                "    0\n" +
                "    -\n";
        assertEquals(expected, longDivision.createDivision());
    }

    @Test
    public void DivisionByOneDigitNumberWithMissedZero() {
        longDivision = new LongDivision(10004, 4);
        String expected = "_10004|4\n" +
                "  8   |2501\n" +
                "  -\n" +
                " _20\n" +
                "  20\n" +
                "  --\n" +
                "   _4\n" +
                "    4\n" +
                "    -\n";
        assertEquals(expected, longDivision.createDivision());
    }

    @Test
    public void DivisionWithPeriodicFraction() {
        longDivision = new LongDivision(1000, 3);
        String expected = "_1000|3\n" +
                "  9  |333\n" +
                "  -\n" +
                " _10\n" +
                "   9\n" +
                "   -\n" +
                "  _10\n" +
                "    9\n" +
                "    -\n";
        assertEquals(expected, longDivision.createDivision());
    }

    @Test
    public void DivisionByTwoDigitNumber() {
        longDivision = new LongDivision(31414, 25);
        String expected = "_31414|25\n"+
                " 25   |1256\n"+
                " --\n"+
                " _64\n"+
                "  50\n"+
                "  --\n"+
                " _141\n"+
                "  125\n"+
                "  ---\n"+
                "  _164\n"+
                "   150\n"+
                "   ---\n";
        assertEquals(expected, longDivision.createDivision());
    }

    @Test
    public void DivisionByThreeDigitNumber() {
        longDivision = new LongDivision(1242458, 123);
        String expected = "_1242458|123\n"+
                " 123    |10101\n"+
                " ---\n"+
                "  _124\n"+
                "   123\n"+
                "   ---\n"+
                "    _158\n"+
                "     123\n"+
                "     ---\n";
        assertEquals(expected, longDivision.createDivision());
    }


}