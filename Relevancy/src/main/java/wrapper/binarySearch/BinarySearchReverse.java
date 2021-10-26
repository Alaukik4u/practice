package wrapper.binarySearch;

public class BinarySearchReverse {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 5,4,3,2,1 };
        int n = arr1.length;
        int key = 4;
        System.out.println("Index of the element is : " + binaryS(arr1, 0, n-1, key));
    }

    private static int binaryS(int[] arr1, int low, int high, int key) {

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                return mid;
            }else if(arr1[mid] > key){
                low = mid+1;
            }else if(arr1[mid] < key){
                high= mid-1;
            }
        }
        return -1;
    }
}
