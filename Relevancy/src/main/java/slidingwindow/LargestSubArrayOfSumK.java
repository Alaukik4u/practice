package slidingwindow;

public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int n = arr.length;
        int k = 15;
        System.out.println("Length = " +
                lenOfLongSubarr(arr, n, k));
    }

    private static int lenOfLongSubarr(int[] arr, int n, int k) {
        int i=0, j=0, sum=0;
        int max = Integer.MIN_VALUE;
        while(j<n){
            sum +=arr[j];

            if(sum < k){
                j++;
            }else if(sum == k){
                max = Math.max(max, (j-i+1));
                j++;
            }else if(sum > k){
                while(sum > k){
                    sum-=arr[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
