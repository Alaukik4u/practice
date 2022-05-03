package wrapper.binarySearch;

public class MinimumDifferenceKeySortedArray {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 1, 2, 3, 5, 6, 8, 9, 10 };
        int n = arr1.length;
        int key = 7;
        System.out.println("min diff  element is : " + binaryS(arr1, 0, n-1, key));
    }

    private static int binaryS(int[] arr, int low, int high, int key) {
        if(key < arr[low]){
            return arr[low];
        }else if(key > arr[high]){
            return arr[high];
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key){
                return arr[mid];
            }else if(arr[mid] > key){
                high = mid-1;
            }else if(arr[mid] < key){
                low = mid+1;
            }
        }
        return  Math.abs(arr[low]-key) > Math.abs(arr[high]-key) ? arr[low] :arr[high] ;
    }


}
