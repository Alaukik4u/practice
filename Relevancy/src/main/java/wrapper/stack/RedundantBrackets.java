package wrapper.stack;

import java.util.Stack;

public class RedundantBrackets {

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(findRedundant(str));;

        str = "(a+(b)/(c))";
        System.out.println(findRedundant(str));

        str = "(a+b*(c-(d)))";
        System.out.println(findRedundant(str));
    }

    private static boolean findRedundant(String str) {
        char[] charArray = str.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char ch : charArray){


            if(ch == ')'){
                char c = stack.pop();
                boolean flag = true;
                while(stack.peek() != '('){

                    if(c =='+' || c =='-' || c =='*' || c =='/' ){
                        flag = false;
                    }
                    c = stack.pop();
                }
                if(flag == true){
                    return true;
                }
            }else{
                stack.push(ch);
            }


        }

        return false;
    }
}
