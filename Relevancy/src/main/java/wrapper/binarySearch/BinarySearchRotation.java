package wrapper.binarySearch;

public class BinarySearchRotation {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 8, 9, 10, 11, 2, 3};
        int n = arr1.length;
        System.out.println("Index of the pivot element is : " + binaryRotation(arr1,0,n-1));
    }

    private static int binaryRotation(int[] arr1, int low, int high) {
       if(high < low){
           return -1;
       }

       if(high == low)
           return low;
       int mid = (low + high)/2;

       if(mid < high &&  arr1[mid] > arr1[mid+1]){
           return mid;
        }else if (mid > low &&  arr1[mid] < arr1[mid-1]){
           return mid-1;
       }else if(arr1[low] > arr1[mid]){
            return binaryRotation(arr1,low,mid-1);
       }else{
           return binaryRotation(arr1,mid+1, high);
       }
    }



}
