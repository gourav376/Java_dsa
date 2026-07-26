class SortedArray{
    static boolean isSortedasc(int arr[]){
        for(int i = 0 ; i < arr.length -1 ; i++){
            if(arr[i] > arr[i+1] ) {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String [] gigachaad){
        int [] arr = {1, 2, 3, 4, 5};
        System.out.println("Is array sorted in ascending order? " + java.util.Arrays.toString(arr) + " " + isSortedasc(arr));
        int [] rizz = {5, 4, 3, 2, 1};
        System.out.println("Is array sorted in ascending order? " + java.util.Arrays.toString(rizz) + " " + isSortedasc(rizz));
    }
}