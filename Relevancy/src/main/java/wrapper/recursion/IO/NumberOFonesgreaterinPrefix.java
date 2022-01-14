package wrapper.recursion.IO;

public class NumberOFonesgreaterinPrefix {


    public static void main(String[] args) {
        int n=3;
        generateParenthesis("", 0, 0, n);
    }

    private static void generateParenthesis(String input, int ones, int zeroes, int n) {

        if(n==0){
            System.out.print(input+" ");
            return;
        }

        String output = input;
        generateParenthesis(output+"1",ones+1, zeroes, n-1);

        if(ones > zeroes){
            generateParenthesis(output+"0",ones, zeroes+1, n-1);
        }

    }
}
