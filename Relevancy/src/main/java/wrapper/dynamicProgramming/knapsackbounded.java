package wrapper.dynamicProgramming;

public class knapsackbounded {

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        int [][] t = new int [n+1][w+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){

                if(i==0){
                    t[i][j] =0;
                }else if(j==0){
                    t[i][j] =0;
                }else if (j-wt[i-1]>=0){
                    t[i][j] = Math.max(t[i-1][j], val[i-1]+ t[i-1][j-wt[i-1]]);
                }else{
                    t[i][j] = t[i-1][j];
                }
        }
    }


    //print matrix
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[n][w];
    }
}
