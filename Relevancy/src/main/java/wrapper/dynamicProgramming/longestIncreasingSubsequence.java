package wrapper.dynamicProgramming;

import java.util.Arrays;

public class longestIncreasingSubsequence {


    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        int arr1[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

        Arrays.sort(arr1);
        printArray(arr);
        printArray(arr1);

        System.out.println("Length of lis is " + LCSUtils(arr, arr1) + "\n");
    }

    private static void printArray(int[] arr) {
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int LCSUtils(int[] arr, int[] arr1) {
        int n1 =arr.length, n2=arr1.length;
        int[][] t = new int[n1+1][n2+1];
        int j = 0, i = 0;
        for (i = 0; i <= n1; i++) {
            for (j = 0; j <= n2; j++) {

                if(i ==0 || j ==0){
                    t[i][j] =0;
                }else if(arr[i-1] == arr1[j-1]){
                    t[i][j] = 1+t[i-1][j-1];
                }else{

                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }

            }
        }
        return t[n1][n2];

    }
}