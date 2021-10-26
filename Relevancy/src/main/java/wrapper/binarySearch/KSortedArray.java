package wrapper.binarySearch;

import java.util.PriorityQueue;

public class KSortedArray {

    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }

    private static void kSort(int[] arr, int n, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i=0; i<k+1; i++){
            queue.add(arr[i]);
        }
        int index =0;
        for(int i=k+1; i<n; i++){
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }

        while(!queue.isEmpty()){
            arr[index++] = queue.poll();
        }
    }
}
