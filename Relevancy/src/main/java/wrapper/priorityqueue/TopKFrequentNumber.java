package wrapper.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import static wrapper.stack.TrappingRainWater.printArray;

public class TopKFrequentNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,4,5};
        printArray(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter top K to find the frequent number");
        int frequent = sc.nextInt();
        printFrequentNumber(arr, frequent);
    }

    private static void printFrequentNumber(int[] arr, int frequent) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i: arr){
            if(frequencyMap.get(i) == null){
                frequencyMap.put(i, 1);
            }else{
                frequencyMap.put(i, frequencyMap.get(i) +1);
            }
        }

        PriorityQueue<HeapNode> minDistanceHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            minDistanceHeap.add(new HeapNode(entry.getKey(), entry.getValue()));

            if(minDistanceHeap.size() > frequent){
                minDistanceHeap.poll();
            }
        }

        System.out.println(frequent + " frequent points are below ::");
        for(HeapNode node : minDistanceHeap){
            System.out.println();
            System.out.print("actual node -> "+ node.key + " frequency -> "+ node.value);
        }
    }
}
