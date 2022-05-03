package wrapper.stack;

import java.util.Stack;

public class MinMaxStack {
    Stack<Node> stack = new Stack<>();

    public int peek() {
        if(stack.isEmpty()){
           throw  new IllegalStateException("Stack is empty");
        }

        return stack.peek().value;
    }

    public int pop() {
        if(stack.isEmpty()){
          throw new IllegalStateException("Stack is empty");
        }

        return stack.pop().value;
    }

    public void push(Integer number) {
        int max = number, min = number;
        if(!stack.isEmpty()){
            if(stack.peek().max > number){
                max = stack.peek().max;
            }

            if(stack.peek().min < number){
                min = stack.peek().min;
            }
        }

        stack.push(new Node (number, min, max));
    }

    public int getMin() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        return stack.peek().min;
    }

    public int getMax() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }

        return stack.peek().max;
    }


    public static void main(String[] args)
    {
        MinMaxStack s = new MinMaxStack();
        s.push(5);
        System.out.println(s.getMin());
        System.out.println(s.getMax());
        System.out.println(s.peek());

        s.push(7);
        System.out.println(s.getMin());
        System.out.println(s.getMax());
        System.out.println(s.peek());

        s.push(2);
        System.out.println(s.getMin());
        System.out.println(s.getMax());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.getMin());
        System.out.println(s.getMax());
        System.out.println(s.peek());

    }

}







