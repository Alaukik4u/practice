package slidingwindow;

public class SumSizeK {

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {
        if(n<k){
            System.out.println("invalid input");
            return Integer.MIN_VALUE;
        }

        int i=0, j=0, sum=0;
        int max = Integer.MIN_VALUE;
        while(j<n){
            sum +=arr[j];

            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                max = Math.max(max, sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
