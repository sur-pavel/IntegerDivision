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
        exception.expect(ArithmeticException.class);
        exception.expectMessage("/ by zero");
        longDivision = new LongDivision(100, 0);
    }

    @Test
    public void FirstExpression() {
        longDivision = new LongDivision(1000, 4);
        String expected = "1000|4\n" +
                " 8  |250\n" +
                " 20\n" +
                " 20\n" +
                "   0\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void SecondExpression() {
        longDivision = new LongDivision(10004, 4);
        String expected = "10004|4\n" +
                " 8   |2501\n" +
                " 20\n" +
                " 20\n" +
                "   4\n" +
                "   4\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void ThirdExpression() {
        longDivision = new LongDivision(78459, 4);
        String expected = "78459|4\n" +
                "4    |19614\n" +
                "38\n" +
                "36\n" +
                " 24\n" +
                " 24\n" +
                "   5\n" +
                "   4\n" +
                "   19\n" +
                "   16\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void FourthExpression() {
        longDivision = new LongDivision(1000, 3);
        String expected = "1000|3\n" +
                " 9  |333\n" +
                " 10\n" +
                "  9\n" +
                "  10\n" +
                "   9\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void FifthExpression() {
        longDivision = new LongDivision(31414, 25);
        String expected = "31414|25\n" +
                "25   |1256\n" +
                " 64\n" +
                " 50\n" +
                " 141\n" +
                " 125\n" +
                "  164\n" +
                "  150\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void SixthExpression() {
        longDivision = new LongDivision(780909, 342);
        String expected = "780909|342\n" +
                "684   |2283\n" +
                " 969\n" +
                " 684\n" +
                " 2850\n" +
                " 2736\n" +
                "  1149\n" +
                "  1026\n";
        assertEquals(longDivision.longDivide(), expected);
    }

    @Test
    public void SeventhExpression() {
        longDivision = new LongDivision(1242458, 123);
        String expected = "1242458|123\n" +
                "123    |10101\n" +
                "  124\n" +
                "  123\n" +
                "    158\n" +
                "    123\n";
        assertEquals(longDivision.longDivide(), expected);
    }


}