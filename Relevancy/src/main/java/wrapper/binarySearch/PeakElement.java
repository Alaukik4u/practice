package wrapper.binarySearch;

public class PeakElement {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 20, 4, 1, 0 };
        int n = arr.length;

        System.out.print("Index of a peak point is " + findPeak(arr, 0,n-1));
    }

    private static int findPeak(int[] arr, int low, int high) {

        while(low <=high){
            int mid = (low+high)/2;
            if(mid != low && mid !=high){
                if(arr[mid] > arr[mid-1] && arr[mid] >arr[mid+1]){
                    return mid;
                }else if(arr[mid] > arr[mid-1]){
                    low = mid+1;
                }else if(arr[mid] < arr[mid-1]){
                    high = mid-1;
                }
            }else if(mid ==low){
                if(arr[mid]<arr[mid+1]){
                    return mid+1;
                }else{
                    return mid;
                }
            }else if(mid ==high){
                if(arr[mid]<arr[mid-1]){
                    return mid-1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
}
