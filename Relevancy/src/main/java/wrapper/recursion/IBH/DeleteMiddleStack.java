package wrapper.recursion.IBH;

import java.util.Stack;
import java.util.stream.Collectors;

import static wrapper.stack.MAH.printArray;

public class DeleteMiddleStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1); stack.add(2); stack.add(3); stack.add(4); stack.add(5);

        int k =  stack.size()/2 + 1;
        printArray(stack.stream().collect(Collectors.toList()));
        deleteStack(stack, k);
        printArray(stack.stream().collect(Collectors.toList()));

    }

    private static void deleteStack(Stack<Integer> stack, int k) {
        if(stack.size() == 0)
            return;

        deleteMiddleStack(stack, k);
    }


    private static void deleteMiddleStack(Stack<Integer> stack, int k) {
        if(k==1){
           stack.pop();
           return;
        }

        int value = stack.pop();
        deleteMiddleStack(stack, k-1);

        stack.add(value);
    }
}
