import java.util.Arrays;

public class MissingNumInArray {

    // 1. Brute Force Approach
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    public static int findMissingBruteForce(int[] arr, int n) {
        // Iterate through all natural numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            // Search for 'i' in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            // If a number is not found, it is the missing one
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    // 2. Better Approach (Hash Array / Frequency Array)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public static int findMissingHashing(int[] arr, int n) {
        // Create a hash array of size n + 1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        // Find the number with 0 frequency
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // 3. Optimal Approach 1 (Sum Method)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static int findMissingSum(int[] arr, int n) {
        // Calculate sum of first n natural numbers: (n * (n + 1)) / 2
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        // Calculate sum of elements in the array
        for (int num : arr) {
            actualSum += num;
        }

        // The difference gives the missing number
        return (int) (expectedSum - actualSum);
    }

    // 4. Optimal Approach 2 (XOR Method)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public static int findMissingXOR(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        // XOR all elements present in the array
        for (int num : arr) {
            xor2 = xor2 ^ num;
        }

        // xor1 ^ xor2 gives the missing number due to property: X ^ X = 0
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // 3 is missing
        int n = 6; // Total elements if none were missing

        System.out.println("Brute Force: " + findMissingBruteForce(arr, n));
        System.out.println("Hash Method: " + findMissingHashing(arr, n));
        System.out.println("Sum Method: " + findMissingSum(arr, n));
        System.out.println("XOR Method: " + findMissingXOR(arr, n));
    }
}
