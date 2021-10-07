package binarySearch;

public class BinarySearchRotationSearch {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 8, 9, 10, 1, 2, 3, 4, 5, 6};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : " + binaryRotationSearch(arr1,0,n-1,key));
    }

    private static int binaryRotationSearch(int[] arr1, int low, int high, int key) {
        int pivot = binaryRotation(arr1,low,high);

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

    private static int binaryRotation(int[] arr1, int low, int high) {
        int n= arr1.length;

        while(low<=high){
            int mid = (low+high)/2;
            int previous = ((mid-1+n)%n);
            int next = ((mid+1)%n);

            if(arr1[mid] < arr1[previous] && arr1[mid]<arr1[next]){
              return mid;
            }else if(arr1[mid] >= arr1[low]){
                low=mid+1;
            }else if(arr1[mid] <= arr1[high]){
                high = mid-1;
            }
        }

        return -1;
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
