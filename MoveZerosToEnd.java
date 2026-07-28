import java.util.Arrays;

class MoveZerosToEnd {
    public static void moveZerosToEnd(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        // Fill the remaining positions with zeros
        while (count < n) {
            arr[count] = 0;
            count++;
        }
    }

    public static void optimalMoveZerosToEnd(int[] arr) {
        int n = arr.length;
        int  j = -1; // pointer to tract last zero position 
        for (int i = 0 ; i < n ; i++){
            if(arr[i]== 0 )
            {
                j = i ;
                break;
            }
        }
        for (int i = j+1 ; i< n; i++){
            if(arr[i] != 0){
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
        
        
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println("Array before moving zeros: " + Arrays.toString(arr));
        moveZerosToEnd(arr);
        System.out.println("Array after moving zeros: " + Arrays.toString(arr));

        int[] arr2 = {0, 1, 0, 3, 12};
        System.out.println("Array before moving zeros (optimal): " + Arrays.toString(arr2));
        optimalMoveZerosToEnd(arr2);
        System.out.println("Array after moving zeros (optimal): " + Arrays.toString(arr2));
    }
}   