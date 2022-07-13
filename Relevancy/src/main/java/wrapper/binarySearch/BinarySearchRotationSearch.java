package wrapper.binarySearch;

public class BinarySearchRotationSearch {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 3,1};
        int n = arr1.length;
        int key = 1;
        System.out.println("Index of the element is : " + binaryRotationSearch(arr1,0,n-1,key));
    }

    private static int binaryRotationSearch(int[] arr1, int low, int high, int key) {
        int pivot = binaryRotation(arr1,low,high);
        System.out.println("pivot element ::"+pivot);

        if(pivot ==-1){
            return binaryS(arr1, low,high,key);
        }

        if(arr1[pivot]==key){
            return pivot;
        }else if(arr1[0]<=key){
            return binaryS(arr1, low, pivot-1,key);
        }else{
            return binaryS(arr1, pivot+1, high,key);
        }
    }

    private static int binaryRotation(int[] arr, int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return binaryRotation(arr, low, mid - 1);
        return binaryRotation(arr, mid + 1, high);
    }


    private static int binaryS(int[] arr1, int low, int high, int key) {

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                return mid;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return -1;
    }

}
