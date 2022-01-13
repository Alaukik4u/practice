package wrapper.recursion.IBH;

import java.util.Stack;
import java.util.stream.Collectors;

import static wrapper.stack.MAH.printArray;

public class ReverseSatckIBH {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1); stack.add(2); stack.add(3); stack.add(4); stack.add(5);


        printArray(stack.stream().collect(Collectors.toList()));
        reverseStack(stack);
        printArray(stack.stream().collect(Collectors.toList()));

    }

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.size()==1) {
            return;
        }
        int value = stack.pop();
        reverseStack(stack);
        insert(stack, value);
    }

    private static void insert(Stack<Integer> stack, int value) {
        if(stack.size()==0) {
           stack.add(value);
           return;
        }
        int value1 = stack.pop();
        insert(stack,value);
        stack.add(value1);

    }
}
