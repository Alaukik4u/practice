package binarySearch;

public class Equilibriumpoint {
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int arr_size = arr.length;

        System.out.println("First Point of equilibrium " +
                "is at index " +
                equilibrium(arr, 0, arr.length-1));
    }

    private static int equilibrium(int[] arr, int start, int end) {

        int mid =  start+(end-start)/2;
        int leftSum=0, rightSum=0;

        for(int i=0; i<mid; i++ ){
            leftSum+= arr[i];
        }

        for(int i=mid+1; i<end; i++ ){
            rightSum+= arr[i];
        }


        if(rightSum > leftSum){
            while(mid<end && leftSum<rightSum){
                leftSum+= arr[mid];
                rightSum-=arr[mid+1];
                mid++;
            }
        }else{
            while(mid>0 && leftSum>rightSum){
            leftSum-= arr[mid-1];
            rightSum+=arr[mid];
            mid--;
        }
        }

        if(leftSum == rightSum){
            return mid;
        }

        return -1;
    }
}
