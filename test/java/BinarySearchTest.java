package java;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    // Test for integers
    @Test
    public void testBinarySearchRecursive_IntegerFound() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(4, BinarySearch.binarySearchRecursive(arr, 5)); // Target is 5 at index 4
    }

    @Test
    public void testBinarySearchRecursive_IntegerNotFound() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 11)); // Target 11 not found
    }

    @Test
    public void testBinarySearchRecursive_EmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 5)); // Empty array
    }

    @Test
    public void testBinarySearchRecursive_NullArray() {
        int[] arr = null;
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, 5)); // Null array
    }

    // Test for strings
    @Test
    public void testBinarySearchRecursive_StringFound() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, BinarySearch.binarySearchRecursive(arr, "cherry")); // Target is "cherry" at index 2
    }

    @Test
    public void testBinarySearchRecursive_StringNotFound() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, "fig")); // Target "fig" not found
    }

    @Test
    public void testBinarySearchRecursive_EmptyStringArray() {
        String[] arr = {};
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, "banana")); // Empty array
    }

    @Test
    public void testBinarySearchRecursive_NullStringArray() {
        String[] arr = null;
        assertEquals(-1, BinarySearch.binarySearchRecursive(arr, "banana")); // Null array
    }
}
