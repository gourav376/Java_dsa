import java.util.Arrays;

public class Sort012 {

    public static void countingSort(int[] arr) {
        // Step 1: Create a frequency array for numbers 0, 1, and 2
        int[] counts = new int[3];

        // Step 2: Count frequencies of each number
        for (int num : arr) {
            counts[num]++;
        }

        // Step 3: Overwrite the original array in sorted order
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[index++] = i;
                counts[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Input array
        int[] data = {0, 2, 1, 0, 2, 2, 1, 0, 1, 0};

        System.out.println("Original Array: " + Arrays.toString(data));

        // Sort the array in-place
        countingSort(data);

        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}
