package wrapper.stack;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
       //char[] A =   {'2', '1', '+', '3', '*'};
        char[] A =   {'3','3','+','6' ,'/'};

        System.out.println(evaluateExpression(A));
    }

    private static int evaluateExpression(char[] a) {
        Stack<Character> stk = new Stack<>();

        for(char c : a){
            switch (c){
                case '*':
                    int result = stk.pop() * stk.pop();
                    stk.push((char)result);
                    break;
                case '+':
                     result = stk.pop() + stk.pop();
                    stk.push((char)result);
                    break;

                case '-':
                    result = stk.pop() - stk.pop();
                    stk.push((char)result);
                    break;

                case '/':
                    int second  =stk.pop();
                    int first = stk.pop();
                    result = first/ second;
                    stk.push((char)result);
                    break;

                default:
                    stk.push((char) (c-48));
            }

        }

        return stk.pop();
    }
}
