import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum{

    // 1. Brute Force Approach
    // Time: O(n²), Space: O(1)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution
    }

    // 2. Hash Map Approach (One-Pass)
    // Time: O(n), Space: O(n)
    // Best for: Unsorted arrays where original indices are required
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{}; // No solution
    }

    // 3. Two Pointers Approach
    // Time: O(n log n) due to sorting, Space: O(n) for cloned array
    // Best for: Sorted arrays or when space efficiency is critical after sorting
    // Note: Returns indices from the ORIGINAL array
    public static int[] twoSumTwoPointers(int[] nums, int target) {
        // Create a copy to sort without losing original indices
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i];      // Value
            indexedNums[i][1] = i;            // Original Index
        }

        // Sort based on values
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = indexedNums[left][0] + indexedNums[right][0];
            if (sum == target) {
                return new int[]{indexedNums[left][1], indexedNums[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // No solution
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute Force: " + Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("Hash Map:    " + Arrays.toString(twoSumHashMap(nums, target)));
        System.out.println("Two Pointers:" + Arrays.toString(twoSumTwoPointers(nums, target)));
    }
}   
