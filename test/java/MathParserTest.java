import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathParserTest {

    @Test
    public void testAddition() throws Exception {
        MathParser parser = new MathParser("3 + 5");
        assertEquals(8.0, parser.evaluate(), 0.001);
    }

    @Test
    public void testMultiplication() throws Exception {
        MathParser parser = new MathParser("3 * 5");
        assertEquals(15.0, parser.evaluate(), 0.001);
    }

    @Test
    public void testMixedOperators() throws Exception {
        MathParser parser = new MathParser("3 + 5 * 2");
        assertEquals(13.0, parser.evaluate(), 0.001);
    }

    @Test
    public void testParentheses() throws Exception {
        MathParser parser = new MathParser("(3 + 5) * 2");
        assertEquals(16.0, parser.evaluate(), 0.001);
    }

    @Test
    public void testFloatingPoint() throws Exception {
        MathParser parser = new MathParser("3.5 + 2.5");
        assertEquals(6.0, parser.evaluate(), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        MathParser parser = new MathParser("3 / 0");
        Exception exception = assertThrows(Exception.class, parser::evaluate);
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @Test
    public void testInvalidExpression() {
        MathParser parser = new MathParser("3 + * 5");
        Exception exception = assertThrows(Exception.class, parser::evaluate);
        assertTrue(exception.getMessage().contains("Unexpected character"));
    }
}
