package wrapper.recursion.IBH;

public class Factorial_IBH {
    public static void main(String[] args) {

        int n=5;
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if(n<0){
            System.out.println("invalid input");
        }

        //Base condition
        if(n==1 || n==0){
            return 1;
        }

        //Induction
        return n*factorial(n-1);//Hypothesis;
    }
}
