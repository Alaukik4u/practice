package wrapper.priorityqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestNumber {
    public static void main(String[] args) {
        int [] arr = {4, 5, 6, 7, 8};
        int noOfElement, closeNumber;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for close proximity");
        closeNumber = sc.nextInt();
        System.out.println("Enter number of close element required");
        noOfElement= sc.nextInt();

        printKNearestNumbers(arr, closeNumber, noOfElement);
    }

    private static void printKNearestNumbers(int[] arr, int closeNumber, int noOfElement) {
        PriorityQueue<KNearestNode> priorityQueue = new PriorityQueue<KNearestNode>((a,b)-> b.proximity -a.proximity);

        for(int i: arr){
            priorityQueue.add(new KNearestNode(i, Math.abs(i-closeNumber)));
            if(priorityQueue.size() > noOfElement){
                priorityQueue.poll();
            }
        }

        System.out.println( noOfElement + " Nearest number ::");
        while(priorityQueue.size() >0){
            System.out.print( priorityQueue.poll() + " ");
        }
    }
}
