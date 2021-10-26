package wrapper.DivideandConquer;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,8,3,7};

        printArray(arr);
        quicksort(arr,0, arr.length-1);
        printArray(arr);

    }

    private static void quicksort(int[] arr, int start, int end) {
        if(start<end){
            int partition = partition(arr, start, end);
            quicksort(arr, start, partition-1);
            quicksort(arr, partition+1, end);

        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int j=0, i=j-1;
        for(j=0; j<=end-1; j++){
            if(arr[j] < pivot){
                i=i+1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[end] = temp;

        return i+1;
    }

    private static void printArray(int[] arr) {
        for(int a : arr){
            System.out.print(a +" ");
        }
        System.out.println();
    }

}
