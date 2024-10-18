package wrapper.priorityqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

import static wrapper.stack.TrappingRainWater.printArray;

public class TopKClosestnumber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int topK = 3;
        printArray(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to find the closest numbers");
        int closest = sc.nextInt();
        printClosestNumber(arr, closest, topK);
    }

    private static void printClosestNumber(int[] arr, int closest, int topK) {
        PriorityQueue<HeapNode> minDistanceHeap = new PriorityQueue<>((a,b) -> b.value - a.value);
        for(int i: arr){
            minDistanceHeap.add(new HeapNode(i, Math.abs(i-closest)));

            if(minDistanceHeap.size() > topK){
                minDistanceHeap.poll();
            }
        }

        System.out.println(topK + " closest points are below ::");
        for(HeapNode node : minDistanceHeap){
            System.out.println();
            System.out.print("actual node -> "+ node.key + " distance -> "+ node.value);
        }
    }
}
