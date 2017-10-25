package ru.surpavel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class LongDivisionTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private LongDivision longDivision = new LongDivision();
    @Test
   public void DivisionByZero_ThrowException() {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("/ by zero");
        longDivision.longDivide(100, 0);
    }


    }