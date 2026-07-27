
class LeftRotateByDih {
    // problem statement : an arrray rotate it by d places to left d can be any thing even greater than array length
    /*  brute force approach is just do rotate by 1 d times with the help of a temporary variable which is n ^2 complexity */  
    void leftRotateArraybyd(int arr[],int d ){
     //This is slightly better solution than brute force approach as it is n complexity and 1 space complexity
     d = d % arr.length;
     int temp[] = new int[d];
     for (int i = 0 ; i < d ; i++){
         temp[i] = arr[i];
     }
     for(int i = d ;i < arr.length ; i++ ){
         arr[i-d] = arr[i];
     }
     for(int i = 0 ; i < d ; i++){
         arr[arr.length-d+i] = temp[i];
     }
}
    void opimizedLeftRotateArraybyd(int arr[],int d ){
        //This is the most optimized solution as it is 2n complexity and 1 space complexity
        d = d % arr.length;
        reverse(arr, 0, d);
        reverse(arr, d, arr.length);
        reverse(arr, 0, arr.length);
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

public static void main(String args[]){
    int arr[] = {1,2,3,4,5};
    LeftRotateByDih obj = new LeftRotateByDih();
    int d = (int)(Math.random() * 100);
    
    System.out.println("Array before rotation: " + java.util.Arrays.toString(arr) + " and d = " + d); 
    obj.leftRotateArraybyd(arr, d);
    System.out.println("Array after rotation: " + java.util.Arrays.toString(arr));
}
}