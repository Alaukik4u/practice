package wrapper.recursion;

public class MakeNTOM {
    static int min =Integer.MAX_VALUE;
    static int cost =0;
    public static void main(String[] args) {
        int n=2 , m=5;
        System.out.println(" minimum number ::"+getMinCost(n,m));
    }

    private static int getMinCost(int m, int n) {
        if (m == n)
            return 0;

        // only way is to do
        // -1 (m - n) times
        if (m > n)
            return (m - n);

        // not possible
        if (m <= 0 && n > 0)
            return -1;

        // n is greater and n is odd
        if (n % 2 == 1){
            System.out.println(" Performing negation value of m ::"+m+" value of n::"+n);
            return 1 + getMinCost(m, n+1);
        } else{
            System.out.println(" Performing multiplication value of m ::"+m+" value of n::"+n);
            return 2 + getMinCost(m, n/2);
        }

    }
}