package binarySearch;

public class AppearOnce {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
        search(arr, 0, arr.length - 1);
    }

    private static void search(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        if (low == high) {
            System.out.println(arr[low] + " is the number appearing once");
            return;
        }

        int mid = (low + high) / 2;

        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1]) {
                search(arr, mid + 2, high);
            } else {
                search(arr, low, mid);
            }

        } else {
            if (arr[mid] == arr[mid - 1]) {
                search(arr, mid + 1, high);
            } else {
                search(arr, low, mid - 1);
            }
        }
    }
}
