package wrapper.binarySearch;

public class FloorSortedArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int x = 7;
        int index = floorSearch(arr, 0,n - 1, x);
        if (index == -1)
            System.out.print(
                    "Floor of " + x
                            + " doesn't exist in array ");
        else
            System.out.print(
                    "Floor of " + x + " is "
                            + arr[index]);
    }

    private static int floorSearch(int[] arr1, int low, int high, int key) {
        int res=-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                return mid;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                res =mid;
                low = mid+1;
            }
        }
        return res;
    }


}
