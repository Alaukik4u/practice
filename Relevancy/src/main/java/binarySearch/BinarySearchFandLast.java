package binarySearch;

import java.util.Arrays;

public class BinarySearchFandLast {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 1, 2, 3, 3, 3, 3, 8, 9, 10 };
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is first: " + binarySfirst(arr1,0,n-1, key));
        System.out.println("Index of the element is last: " + binarySLast(arr1,0,n-1, key));
        System.out.println("count of the element : " + (binarySLast(arr1,0,n-1, key)-binarySfirst(arr1,0,n-1, key)+1));


    }

    private static int binarySfirst(int[] arr1, int low, int high, int key) {
        int res=-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                res = mid;
                high= mid-1;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return res;
    }

    private static int binarySLast(int[] arr1, int low, int high, int key) {
        int res=-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                res = mid;
                low= mid+1;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return res;
    }


}
