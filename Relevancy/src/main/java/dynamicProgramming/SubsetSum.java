package dynamicProgramming;

public class SubsetSum {
    public static void main(String[] args) {
        int a[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = a.length;


        if (isSubsetSum(a, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] a, int n, int sum) {
        boolean[][] t = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){

                if(j==0){
                    t[i][j] = true;
                }else if(i==0){
                    t[i][j] = false;
                }else if(j-a[i-1] >=0){
                    t[i][j] = t[i-1][j] || t[i-1][j-a[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }

            }
        }

        //print matrix
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[n][sum];
    }
}
