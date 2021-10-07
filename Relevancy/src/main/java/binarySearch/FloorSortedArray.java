package binarySearch;

public class FloorSortedArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int x = 7;
        int index = floorSearch(arr, n - 1, x);
        if (index == -1)
            System.out.print(
                    "Floor of " + x
                            + " doesn't exist in array ");
        else
            System.out.print(
                    "Floor of " + x + " is "
                            + arr[index]);
    }

    private static int floorSearch(int[] arr, int i, int x) {
    }
}
