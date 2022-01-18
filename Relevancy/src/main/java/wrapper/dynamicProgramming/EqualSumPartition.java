package wrapper.dynamicProgramming;

public class EqualSumPartition {
    public static void main(String[] args) {
        int a[] = {5, 1, 11, 5};
        int n = a.length, sum = 0;

        for (int i : a) {
            sum = sum + i;
        }

        if (isSubsetSumWrapper(a, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSumWrapper(int[] a, int len, int sum) {
        if (sum % 2 != 0) {
            return false;
        }
        return isSubsetSum(a, len, sum / 2);

    }

    private static boolean isSubsetSum(int[] a, int len, int sum) {
        boolean[][] t = new boolean[len + 1][sum+1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = true;
                }else if(i == 0){
                    t[i][j] = false;
                }else if(j-a[i-1] >= 0){
                    t[i][j] = t[i-1][j] || t[i-1][j-a[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        //print matrix
        for(int i=0; i<=len; i++){
            for(int j=0; j<=sum; j++){

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[len][sum];
    }
}
