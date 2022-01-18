package wrapper.dynamicProgramming;

public class CountOFSubsetSum {
    public static void main(String[] args) {
        int a[] = {5, 1, 11, 5};
        int sum = 11;
        int n = a.length;
        System.out.println("Found " + isSubsetSum(a, n, sum) + " subset"
                + " with given sum");

    }

    private static int isSubsetSum(int[] a, int n, int sum) {
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (j == 0) {
                    t[i][j] = 1;
                } else if (i == 0) {
                    t[i][j] = 0;
                } else if (j - a[i - 1] >= 0) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }

            }
        }

        //print matrix
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[n][sum];
    }
}
