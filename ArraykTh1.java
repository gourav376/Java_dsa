import java.util.Scanner;
class ArraykTh1{
    static int firstSmallest(int [] arr, int n ){
        int firstSmall = arr[0];
        for(int i = 1;i < n ; i++) {
            if(arr[i] < firstSmall) {
                firstSmall = arr[i];
            }
        }
        return firstSmall;
    }
    static int secondSmallest(int [] arr, int n ){
        int firstSmall = firstSmallest(arr,n);
        int secondSmall = Integer.MAX_VALUE;
      for(int i = 0 ; i < n ; i++)

{if(arr[i]< firstSmall){
    secondSmall = firstSmall;
    firstSmall = arr[i];
}
    if(arr[i] < secondSmall  && arr[i] > firstSmall) {
                secondSmall = arr[i];
            }
}        return secondSmall;
    }
      static int firstLargest(int [] arr, int n ){
        int firstLarge = arr[0];
        for(int i = 1;i < n ; i++) {
            if(arr[i] > firstLarge) {
                firstLarge = arr[i];
            }
        }
        return firstLarge;
    }
    static int secondLargest(int [] arr, int n ){
        int firstLarge = firstLargest(arr,n);
        int secondLarge = Integer.MIN_VALUE;
      for(int i = 0 ; i < n ; i++)

{if(arr[i]> firstLarge){
    secondLarge = firstLarge;
    firstLarge = arr[i];
}     
    if(arr[i] > secondLarge  && arr[i] < firstLarge) {
                secondLarge = arr[i];
            }
}        return secondLarge;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The first smallest element is : " + firstSmallest(arr,n));
        System.out.println("The first largest element is : " + firstLargest(arr,n));
        System.out.println("The second smallest element is : " + secondSmallest(arr,n));
        System.out.println("The second largest element is : " + secondLargest(arr,n));
    }
}
