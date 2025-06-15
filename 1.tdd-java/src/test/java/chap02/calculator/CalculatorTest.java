package chap02.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void plus(){
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.plus(1,2));
        assertEquals(5, calculator.plus(3,2));
    }

}
