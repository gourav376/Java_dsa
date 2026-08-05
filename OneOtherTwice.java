import java.util.HashMap;
import java.util.Map;

public class OneOtherTwice{

    // 1. XOR APPROACH
    // Uses the rule: X ^ X = 0, and X ^ 0 = X. Duplicates cancel out.
    public static int findByXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // 2. MAP APPROACH
    // Stores frequencies in a HashMap, then returns the key with a value of 1.
    public static int findByMap(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 3. BRUTE FORCE APPROACH
    // Uses nested loops to check the frequency of every element.
    public static int findByBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return -1;
    }

    // MAIN METHOD TO TEST ALL APPROACHES
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("--- Finding Unique Element ---");
        System.out.println("XOR Approach Result: " + findByXOR(nums));
        System.out.println("Map Approach Result: " + findByMap(nums));
        System.out.println("Brute Force Result: " + findByBruteForce(nums));
    }
}
