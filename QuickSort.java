class QuickSort{
    public static void quickSortasc(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionasc(arr, low, high);
            quickSortasc(arr, low, pivotIndex - 1);
            quickSortasc(arr, pivotIndex + 1, high);
        }
    }
    private static int partitionasc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);        
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }   
     public static void quickSortdesc(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitiondesc(arr, low, high);
            quickSortdesc(arr, low, pivotIndex - 1);
            quickSortdesc(arr, pivotIndex + 1, high);
        }
    }
    private static int partitiondesc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                swap(arr, i, j);        
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSortasc(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        quickSortdesc(arr, 0, n - 1);
        System.out.println("\nSorted array in descending order: ");
        for (int num : arr) {
            System.out.print(num + " ");    
        }
    }
}