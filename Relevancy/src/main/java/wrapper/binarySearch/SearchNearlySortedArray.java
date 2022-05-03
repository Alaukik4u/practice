package wrapper.binarySearch;

public class SearchNearlySortedArray {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 1, 3, 2, 6, 5, 7, 8, 10, 9 };
        int n = arr1.length;
        int key = 7;
        System.out.println("Index of the element in nearly sorted array is : " + binaryS(arr1, 0, n-1, key));
    }

    private static int binaryS(int[] arr, int low, int high, int key) {
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid-1] == key){
                return mid-1;
            }else if(arr[mid+1] == key){
                return mid+1;
            }else if(arr[mid] > key){
                high = mid-2;
            }else if(arr[mid] < key){
                low = mid+2;
            }
        }
        return -1;
    }
}
