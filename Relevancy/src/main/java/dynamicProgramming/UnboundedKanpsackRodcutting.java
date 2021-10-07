package dynamicProgramming;

//here we will be given one length (we will make length array out of it) and one price array
public class UnboundedKanpsackRodcutting {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        int[] length = new int[]{1,2,3,4,5,6,7,8};


        System.out.println("Maximum Obtainable Value is " + cutRod(arr, length,size));
    }

    private static int cutRod(int[] arr, int[] length, int size) {
        int[][] t = new int[size+1][size+1];
        int j=0,i=0;

        for(i=0; i<=size; i++){
            for(j=0; j<=size; j++){

                if(i==0 || j==0){
                    t[i][j] = 0;
                }else if(length[i-1] <= j){

                    t[i][j] = Math.max(t[i-1][j], (arr[i-1]+t[i][j-length[i-1]]));

                }else{
                    t[i][j] = t[i-1][j];
                }

            }
        }

        //print matrix
        for(i=0; i<=size; i++){
            for(j=0; j<=size; j++){

                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[size][size];
    }
}
