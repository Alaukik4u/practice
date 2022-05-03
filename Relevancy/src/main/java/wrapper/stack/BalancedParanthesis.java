package wrapper.stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String expr = "([{}])";

        // Function call
        if (balancedBrackets(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }


    public static boolean balancedBrackets(String str) {

        if (str == null || str.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for (char character : str.toCharArray()) {
            switch (character) {
                case '(':
                    stack.push(character);
                    break;
                case '{':
                    stack.push(character);
                    break;
                case '[':
                    stack.push(character);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;

            }
        }
        return stack.isEmpty();
    }
}
