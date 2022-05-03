package wrapper.binarySearch;

public class BinarySearchInInfiniteArray {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
        int n = arr1.length;
        int key = 8;
        int low =0, high=1;
        //getting the actual binary search array as per key for infinite series
        while(arr1[high] <= key ){
            low = high;
            high = 2*high;
        }
        System.out.println("Index of the element is : " + binaryS(arr1, low, high, key));
    }

    private static int binaryS(int[] arr, int low, int high, int key) {
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                high = mid-1;
            }else if(arr[mid] < key){
                low = mid+1;
            }
        }
        return -1;
    }


}
