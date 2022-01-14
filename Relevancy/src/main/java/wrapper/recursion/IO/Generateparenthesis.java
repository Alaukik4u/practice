package wrapper.recursion.IO;

public class Generateparenthesis {


    public static void main(String[] args) {
        int n=3;
        generateParenthesis("", n, n);
    }

    private static void generateParenthesis(String input, int open, int closed) {

        if(open == 0 && closed ==0){
            System.out.print(input+" ");
            return;
        }

        String output = input;

        if(open !=0){
            generateParenthesis(output+"(",open-1, closed);
        }

        if(open < closed){
            generateParenthesis(output+")",open, closed-1);
        }

    }
}
