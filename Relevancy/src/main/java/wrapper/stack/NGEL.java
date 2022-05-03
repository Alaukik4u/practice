package wrapper.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NGEL {

    public static void main(String[] args) {
        int arr[]= {11, 13, 21, 3, 22};
        int n = arr.length;
        printNGE(arr, n);
    }

    private static void printNGE(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){

                while(!stack.isEmpty() && arr[i]>=stack.peek()){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(stack.peek());
                }

            stack.push(arr[i]);
        }

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }
}
