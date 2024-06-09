package wrapper.recursion.IBH;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static wrapper.stack.MAH.printArray;

public class SortStackRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        printStack(stack);
        sortStack(stack);
        printStack(stack);


    }

    private static void sortStack(Stack<Integer> stack) {
        if(stack.size() <= 1)
            return;
        int insertLast = stack.pop();
        sortStack(stack);
        insert(stack, insertLast);
    }

    private static void insert(Stack<Integer> stack, int insertLast) {
        if(stack.size() == 0 || stack.peek() <= insertLast){
            stack.push(insertLast);
            return;
        }

        int popLast = stack.pop();
        insert(stack, insertLast);
        stack.push(popLast);
    }

    private static void printStack(Stack<Integer> stack) {
        for(Integer i: stack)
            System.out.print(i + " ");
        System.out.println();
    }
}
