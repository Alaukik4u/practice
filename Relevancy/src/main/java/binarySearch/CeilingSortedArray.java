package binarySearch;

public class CeilingSortedArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int x = 7;
        int index = CeilingSearch(arr, 0,n - 1, x);
        if (index == -1)
            System.out.print(
                    "Ceiling of " + x
                            + " doesn't exist in array ");
        else
            System.out.print(
                    "Ceiling of " + x + " is "
                            + arr[index]);
    }

    private static int CeilingSearch(int[] arr1, int low, int high, int key) {
        int res=-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                return mid;
            }else if(arr1[mid] > key){
                res = mid;
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return res;
    }


}
