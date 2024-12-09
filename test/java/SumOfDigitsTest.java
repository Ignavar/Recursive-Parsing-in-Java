import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SumOfDigitsTest {

    @Test
    public void testPositiveNumber() {
        assertEquals(15, SumOfDigits.sumOfDigits(12345));
    }

    @Test
    public void testSingleDigit() {
        assertEquals(7, SumOfDigits.sumOfDigits(7));
    }

    @Test
    public void testZero() {
        assertEquals(0, SumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testNegativeNumber() {
        assertEquals(15, SumOfDigits.sumOfDigits(-12345));
    }

    @Test
    public void testLargeNumber() {
        assertEquals(54, SumOfDigits.sumOfDigits(9876543210));
    }

    @Test
    public void testAnotherNegativeNumber() {
        assertEquals(27, SumOfDigits.sumOfDigits(-9999));
    }
}
