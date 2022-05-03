package wrapper.binarySearch;

public class BinarySearchfirst1InbinarysortedInfiniteseries {
    public static void main(String[] args) {
        // Let us search 3 in below array
        int arr1[] = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1 };
        int n = arr1.length;
        int key = 1;
        int low =0, high=1;
        while(arr1[high] != arr1[arr1.length-1]){
            low = high;
            high = (2*high <= arr1.length-1) ? 2*high : arr1.length-1;
        }
        System.out.println("Index of the element is first: " + binarySfirst(arr1,low,high, key));
        System.out.println("Index of the element is last: " + binarySLast(arr1,low,high, key));
        System.out.println("count of the element : " + (binarySLast(arr1,low,high, key)-binarySfirst(arr1,low,high, key)+1));


    }

    private static int binarySfirst(int[] arr1, int low, int high, int key) {
        int res=-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                res = mid;
                high= mid-1;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return res;
    }

    private static int binarySLast(int[] arr1, int low, int high, int key) {
        int res=-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr1[mid] == key){
                res = mid;
                low= mid+1;
            }else if(arr1[mid] > key){
                high= mid-1;
            }else if(arr1[mid] < key){
                low = mid+1;
            }
        }
        return res;
    }


}
