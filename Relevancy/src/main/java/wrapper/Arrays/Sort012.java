package wrapper.Arrays;

import static wrapper.DivideandConquer.HeapSort.swap;

public class Sort012 {

    static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }

    private static void sort012(int[] arr, int arr_size) {
        int mid = 0, low = 0, high = arr_size - 1;


        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    swap(arr, mid, low);
                    low++;
                    mid++;
                    break;
                } case 1:{
                    mid++;
                    break;
                }case 2:{
                    swap(arr, mid, high);
                    high--;
                    break;
                }

            }


        }
    }

}
