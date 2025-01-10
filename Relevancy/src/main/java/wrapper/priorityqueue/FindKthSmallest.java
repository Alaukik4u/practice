package wrapper.priorityqueue;

import java.util.PriorityQueue;

public class FindKthSmallest {
    public static void main(String[] args) {
        int arr[] = {2, 3,4,1,12};
        printArray(arr);
        printKthSmallestArray(arr, 4);

    }

    private static void printKthSmallestArray(int[] arr, int maxNumber) {
        PriorityQueue<Integer> kmaxElement = new PriorityQueue<>((a,b)-> (b-a));
        for(int i=0; i< arr.length; i++){
            kmaxElement.add(arr[i]);
            if(kmaxElement.size() > maxNumber){
                kmaxElement.poll();
            }
        }


            System.out.print( kmaxElement.poll() + "  is kth smallest ");
    }

    private static void printArray(int[] arr) {
        for(int i : arr){
            System.out.print(i+" ");
            System.out.println();
        }
    }

}
