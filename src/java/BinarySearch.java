package java;
public class BinarySearch {

    // Recursive Binary Search for integers
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    // Helper method for recursion
    private static int binarySearchRecursiveHelper(int[] arr, int target, int left, int right) {
        if (arr == null || arr.length == 0) {
            return -1; // Error handling for null or empty array
        }

        // Base case: when the search range is invalid
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found at mid index
        } else if (arr[mid] > target) {
            return binarySearchRecursiveHelper(arr, target, left, mid - 1); // Search in left half
        } else {
            return binarySearchRecursiveHelper(arr, target, mid + 1, right); // Search in right half
        }
    }

    // Recursive Binary Search for strings
    public static int binarySearchRecursive(String[] arr, String target) {
        return binarySearchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    // Helper method for string array
    private static int binarySearchRecursiveHelper(String[] arr, String target, int left, int right) {
        if (arr == null || arr.length == 0) {
            return -1; // Error handling for null or empty array
        }

        // Base case: when the search range is invalid
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid].equals(target)) {
            return mid; // Target found at mid index
        } else if (arr[mid].compareTo(target) > 0) {
            return binarySearchRecursiveHelper(arr, target, left, mid - 1); // Search in left half
        } else {
            return binarySearchRecursiveHelper(arr, target, mid + 1, right); // Search in right half
        }
    }

    // Find all indices of the target if it appears multiple times
    public static int[] binarySearchAllIndices(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Error handling for null or empty array
        }

        // First find the index of the target
        int index = binarySearchRecursive(arr, target);
        if (index == -1) {
            return new int[0]; // If the target is not found, return empty array
        }

        // Now find all occurrences
        int[] result = new int[arr.length];
        int count = 0;
        // Search to the left of the found index
        int left = index;
        while (left >= 0 && arr[left] == target) {
            result[count++] = left;
            left--;
        }
        // Search to the right of the found index
        int right = index + 1;
        while (right < arr.length && arr[right] == target) {
            result[count++] = right;
            right++;
        }

        // Trim the array to fit the number of found indices
        int[] finalResult = new int[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }

    // Helper method for unit testing
    public static void testBinarySearch() {
        // Test for integer array
        int[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchRecursive(arrInt, 5)); // Expected output: 4
        System.out.println(binarySearchRecursive(arrInt, 10)); // Expected output: -1
        
        // Test for string array
        String[] arrStr = {"apple", "banana", "cherry", "date"};
        System.out.println(binarySearchRecursive(arrStr, "banana")); // Expected output: 1
        System.out.println(binarySearchRecursive(arrStr, "orange")); // Expected output: -1
        
        // Test for multiple occurrences of target value
        int[] arrMulti = {1, 2, 2, 2, 5, 6, 7};
        int[] result = binarySearchAllIndices(arrMulti, 2);
        for (int index : result) {
            System.out.print(index + " "); // Expected output: 1 2 3
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 11;

        int result = binarySearchRecursive(sortedArray, target);

        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
