class Sorting {
    public static void selectionSort(int [] arr){
         
        for (int i = 0 ; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void bubbleSort(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
               int flagSwap = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
             
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flagSwap = 1;
                }
              
            }
              if (flagSwap == 0) {
                    break;
                }
        }
    }
    public static void insertionSort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
        System.out.println("after Bubble sort : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    
        selectionSort(arr);
        System.out.println("\nafter Selection sort : ");
        for (int num : arr) {
        System.out.print(num + " ");
        }
        insertionSort(arr);
        System.out.println("\nafter Insertion sort : ");
        for (int num : arr) {
        System.out.print(num + " ");
        }
    }
}
