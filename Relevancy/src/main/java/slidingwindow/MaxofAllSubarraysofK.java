package slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxofAllSubarraysofK {
    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int n = arr.length;
        int k = 3;


        printFirstNegativeInteger(arr, k, n);
    }

    private static void printFirstNegativeInteger(int[] arr, int k, int n) {
        if(n<k){
            System.out.println("invalid input");
            return;
        }

        int i=0, j=0, sum=0;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->(b-a));

        while(j<n){
            queue.add(arr[j]);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){

                max = queue.peek();
                System.out.println(max);
                queue.remove(arr[i]);
                i++;
                j++;
            }
        }
    }
}
