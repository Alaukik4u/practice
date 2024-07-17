package wrapper.priorityqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestPoints {
    public static void main(String[] args) {
        int [][] arr = {{1,1}, {5,5}, {6,6}, {7,7}, {8,8}};
        int closeNumber;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for close proximity");
        closeNumber = sc.nextInt();

        printKClosestPoints(arr, closeNumber);
    }

    private static void printKClosestPoints(int[][] arr, int closeNumber) {
        PriorityQueue<KNearestNode> priorityQueue = new PriorityQueue<>((a,b)-> ((b.xcoordinate*b.xcoordinate+ b.ycoordinate*b.ycoordinate) -(a.xcoordinate*a.xcoordinate+ a.ycoordinate*a.ycoordinate)));
        for(int[] ar : arr){
            priorityQueue.add(new KNearestNode(ar[0], ar[1]));

            if(priorityQueue.size() > closeNumber){
                priorityQueue.poll();
            }
        }

        System.out.println(closeNumber + " nearest points from origin below -> ");
        while(priorityQueue.size() >0){
            System.out.println(priorityQueue.poll());
        }


    }
}
