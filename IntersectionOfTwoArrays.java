import java.util.Arrays;
import java.util.ArrayList;

class IntersectionOfTwoArrays {
    public static int[] bruteIntersect(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    list.add(arr1[i]);
                    break; 
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    public static int[] optimalIntersect(int[] arr1, int[] arr2) {
        // Essential: Sort arrays first if they are not already sorted
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        
        ArrayList<Integer> intersect = new ArrayList<>();
        
        while (i < n1 && j < n2) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                intersect.add(arr1[i]);
                i++;
                j++;
            }
        }
        
        int[] result = new int[intersect.size()];
        for (int k = 0; k < intersect.size(); k++) {
            result[k] = intersect.get(k);
        }
        return result;
    }
     public static void main(String[] args) {
        // Test inputs
        int[] array1 = {4, 9, 5, 2, 8};
        int[] array2 = {9, 4, 9, 8, 4};

        System.out.println("Original Array 1: " + Arrays.toString(array1));
        System.out.println("Original Array 2: " + Arrays.toString(array2));
        System.out.println("------------------------------------------------");

        // 1. Test Brute Force Method
        int[] bruteResult = bruteIntersect(array1, array2);
        System.out.println("Brute Force Intersection: " + Arrays.toString(bruteResult));

        // 2. Test Optimal Two-Pointer Method
        int[] optimalResult = optimalIntersect(array1, array2);
        System.out.println("Optimal Two-Pointer Intersection: " + Arrays.toString(optimalResult));
    }
}
