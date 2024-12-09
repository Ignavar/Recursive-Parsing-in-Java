import java.util.*;

public class MathParser {

    // Define tokens
    private static final Set<Character> operators = Set.of('+', '-', '*', '/');
    private String expression;
    private int index;

    public MathParser(String expression) {
        this.expression = expression.replaceAll("\\s", ""); // Remove spaces
        this.index = 0;
    }

    // Evaluate the mathematical expression
    public double evaluate() throws Exception {
        double result = parseExpression();
        if (index < expression.length()) {
            throw new Exception("Unexpected character at position " + index);
        }
        return result;
    }

    // Parse expressions with addition and subtraction
    private double parseExpression() throws Exception {
        double result = parseTerm();
        while (index < expression.length() && (expression.charAt(index) == '+' || expression.charAt(index) == '-')) {
            char operator = expression.charAt(index++);
            double term = parseTerm();
            if (operator == '+') {
                result += term;
            } else {
                result -= term;
            }
        }
        return result;
    }

    // Parse terms with multiplication and division
    private double parseTerm() throws Exception {
        double result = parseFactor();
        while (index < expression.length() && (expression.charAt(index) == '*' || expression.charAt(index) == '/')) {
            char operator = expression.charAt(index++);
            double factor = parseFactor();
            if (operator == '*') {
                result *= factor;
            } else {
                if (factor == 0) {
                    throw new Exception("Division by zero at position " + index);
                }
                result /= factor;
            }
        }
        return result;
    }

    // Parse factors (numbers or parenthesized expressions)
    private double parseFactor() throws Exception {
        if (index >= expression.length()) {
            throw new Exception("Unexpected end of expression.");
        }

        char currentChar = expression.charAt(index);

        // Handle numbers (integers and floating point)
        if (Character.isDigit(currentChar) || currentChar == '.') {
            return parseNumber();
        }

        // Handle parentheses for sub-expressions
        if (currentChar == '(') {
            index++; // skip '('
            double result = parseExpression();
            if (index >= expression.length() || expression.charAt(index) != ')') {
                throw new Exception("Mismatched parentheses at position " + index);
            }
            index++; // skip ')'
            return result;
        }

        // Invalid character
        throw new Exception("Unexpected character: " + currentChar + " at position " + index);
    }

    // Parse a number (integer or floating point)
    private double parseNumber() throws Exception {
        StringBuilder number = new StringBuilder();
        boolean hasDot = false;

        while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            char currentChar = expression.charAt(index++);
            if (currentChar == '.') {
                if (hasDot) {
                    throw new Exception("Invalid number format at position " + (index - 1));
                }
                hasDot = true;
            }
            number.append(currentChar);
        }

        try {
            return Double.parseDouble(number.toString());
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format at position " + (index - number.length()));
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            String expression = "3 + 5 * (2 + 3)";
            MathParser parser = new MathParser(expression);
            double result = parser.evaluate();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
