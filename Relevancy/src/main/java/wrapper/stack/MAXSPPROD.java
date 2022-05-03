package wrapper.stack;

import java.util.*;

import static wrapper.stack.MAH.printArray;

public class MAXSPPROD {
    public static void main(String[] args) {
        int arr[]= {7, 5, 7, 9, 8, 7 };
        for(int i: arr){
            System.out.print(i+ " ");
        }
        System.out.println();
        int n = arr.length;
        List<Integer> ngelList = printNGEL(arr);
        printArray(ngelList);
        List<Integer> ngerList = printNGER(arr);
        printArray(ngerList);

        int max = Integer.MIN_VALUE;

        for(int i=0; i< ngelList.size(); i++){
            max = Math.max(ngelList.get(i)*ngerList.get(i), max);
        }

        System.out.println("Maximum value ::"+ max);
    }

    private static List<Integer> printNGEL(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){

            while(!stack.isEmpty() && arr[i]>= arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek());
            }

            stack.push(i);
        }
        return list;
    }

    private static List<Integer> printNGER(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek());
            }

            stack.push(i);
        }

        Collections.reverse(list);
        return list;
    }
}
