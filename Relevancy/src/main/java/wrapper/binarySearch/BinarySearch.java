package wrapper.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
        int n = arr1.length;
        int key = 11;
        System.out.println("Index of the element is : " + binaryS(arr1, 0, n-1, key));
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
