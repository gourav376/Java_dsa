public class SubArrayLengthWithSum{

    // 1. Brute Force Method: O(n^3) Time, O(1) Space
    public static int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += nums[k];
                }
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    // 2. Better Method: O(n^2) Time, O(1) Space
    public static int maxSubArrayBetter(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    // 3. Best Method (Kadane's Algorithm): O(n) Time, O(1) Space
    public static int maxSubArrayBest(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Test array with both positive and negative numbers
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("--- Subarray Maximum Sum Results ---");
        System.out.println("Brute Force Method [O(n^3)]: " + maxSubArrayBruteForce(nums));
        System.out.println("Better Method      [O(n^2)]: " + maxSubArrayBetter(nums));
        System.out.println("Best Method (Kadane)[O(n)]:  " + maxSubArrayBest(nums));
    }
}
