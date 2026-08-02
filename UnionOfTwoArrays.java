import java.util.HashSet;
import java.util.Arrays;

class UnionOfTwoArrays {     
    // Corrected Brute Force approach using a HashSet
    public static int[] unionBrute(int arr1[], int arr2[]) {         
        var st = new HashSet<Integer>();         
        for (int i = 0; i < arr1.length; i++) {             
            st.add(arr1[i]);         
        }         
        for (int i = 0; i < arr2.length; i++) {             
            st.add(arr2[i]);         
        }         
        
        // Efficiently convert Set to primitive int array
        int[] inArr = new int[st.size()];
        int idx = 0;
        for (int num : st) {
            inArr[idx++] = num;
        }
        return inArr;     
    }     

    // Corrected Two-Pointer approach (Requires sorted arrays with no internal duplicates)
    public static int[] unionMerge(int arr1[], int arr2[]) {     
        int n = arr1.length;     
        int m = arr2.length;     
        int i = 0, j = 0;     
        int tempArr[] = new int[n + m];     
        int k = 0;     
        
        while (i < n && j < m) {         
            if (arr1[i] < arr2[j]) {         
                if (k == 0 || tempArr[k - 1] != arr1[i]) tempArr[k++] = arr1[i];             
                i++;         
            } else if (arr1[i] > arr2[j]) {             
                if (k == 0 || tempArr[k - 1] != arr2[j]) tempArr[k++] = arr2[j];             
                j++;         
            } else {         
                if (k == 0 || tempArr[k - 1] != arr1[i]) tempArr[k++] = arr1[i];             
                i++;             
                j++;         
            }     
        }     
        while (i < n) {         
            if (k == 0 || tempArr[k - 1] != arr1[i]) tempArr[k++] = arr1[i];         
            i++;     
        }     
        while (j < m) {                
            if (k == 0 || tempArr[k - 1] != arr2[j]) tempArr[k++] = arr2[j];         
            j++;              
        }    
        
        // Trim the array to the actual number of unique elements inserted
        return Arrays.copyOf(tempArr, k);   
    }     

    public static void main(String[] args) {         
        int arr1[] = {1, 2, 3, 4, 5};         
        int arr2[] = {1, 2};         
        int unionArr1[] = unionBrute(arr1, arr2);         
        System.out.println("Brute Force Union: " + Arrays.toString(unionArr1));         
        
        int arr3[] = {2, 32, 34, 35, 52};         
        int arr4[] = {1, 4, 5, 8, 9, 52, 57};     
        int unionArr2[] = unionMerge(arr3, arr4);
        System.out.println("Two-Pointer Union: " + Arrays.toString(unionArr2));
    } 
}
