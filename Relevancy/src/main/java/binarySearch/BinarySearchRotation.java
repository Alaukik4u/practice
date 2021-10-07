package binarySearch;

import java.util.Arrays;

public class BinarySearchRotation {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 8, 9, 10, 1, 2, 3, 3, 3, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : " + binaryRotation(arr1,0,n-1));
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

}
