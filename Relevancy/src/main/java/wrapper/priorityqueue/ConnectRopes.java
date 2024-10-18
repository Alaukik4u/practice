package wrapper.priorityqueue;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        printMinimumCostRopes(arr);
    }

    private static void printMinimumCostRopes(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int cost=0;
        for (int i : arr){
            priorityQueue.add(i);

            if(priorityQueue.size() >2){
                int first = priorityQueue.poll();
                System.out.print( first + " selected");
                System.out.println();
                int second = priorityQueue.poll();
                System.out.print( second + " selected");
                System.out.println();
                cost = cost + first+ second;
                System.out.println(cost +" till now");
                priorityQueue.add(first+second);
            }
        }

        int first = priorityQueue.poll();
        System.out.print( first + " selected");
        System.out.println();
        int second = priorityQueue.poll();
        System.out.print( second + " selected");
        System.out.println();
        cost = cost + first+ second;
        System.out.println(cost +" till now");

        System.out.println("minimum cost for ropes ->" + cost);
    }


}
