import java.util.Scanner;

public class SumOfDigits {

    // Function to sum the digits of a number recursively
    public static int sumOfDigits(int number) {
        // Handle negative numbers by converting to positive
        number = Math.abs(number);
        
        // Base case: when the number is reduced to 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: sum the last digit + sum of remaining digits
        return number % 10 + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        // Read input from the user
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        
        // Calculate and print the sum of digits
        int result = sumOfDigits(number);
        System.out.println("The sum of the digits of " + number + " is: " + result);
    }
}
