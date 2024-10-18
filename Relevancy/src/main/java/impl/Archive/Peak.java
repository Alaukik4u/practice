package impl.Archive;

public class Peak {
    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};
        int n = arr.length;

        System.out.print("Index of a peak point is " + findPeak(arr, 0, n - 1));
    }

    private static int findPeak(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid != start && mid != end) {

                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid == start) {

                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }

            } else if (end == mid) {

                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    return mid - 1;
                }

            }

        }
        return -1;
    }

}
