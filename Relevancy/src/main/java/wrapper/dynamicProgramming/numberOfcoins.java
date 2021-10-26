package wrapper.dynamicProgramming;

public class numberOfcoins {
    public static void main(String[] args) {
        int coins[] =  {4,11, 2,2,2, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
    }

    private static int minCoins(int[] coins, int m, int v) {
        int[][] t = new int[m+1][v+1];
        int j=0,i=0;

        for(i=0; i<=m; i++){
            for(j=0; j<=v; j++){

                if(i==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }else if(j==0){
                    t[i][j] = 0;
                }else if(i==1){
                    t[i][j] = (j%coins[0] == 0) ? j/coins[0] : Integer.MAX_VALUE-1;
                }else if(coins[i-1]<=j){
                    t[i][j] = Math.min(t[i-1][j], (1+t[i][j-coins[i-1]]));
                }else{
                    t[i][j] = t[i-1][j];
                }

            }
        }

        //print matrix
        for(i=0; i<=m; i++){
            for(j=0; j<=v; j++){

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[m][v];


    }
}
