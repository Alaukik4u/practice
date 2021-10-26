package wrapper.DivideandConquer;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,8,3,7};

        printArray(arr);
        Heapsort(arr);
        printArray(arr);
    }

    private static void Heapsort(int[] arr) {
        int n= arr.length;

        //build heap
        for(int i=n/2-1; i>=0; i--){
            Heapify(arr, i,n);
        }

        printArray(arr);

        for(int i=n-1; i>0; i--){
            swap(arr, 0, i);
            Heapify(arr, 0,i);
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void Heapify(int[] arr, int index, int n) {
        int largest = index;

        int l = 2*index +1;
        int r = 2*index +2;

        if(l<n && arr[l] > arr[largest]){
            largest = l;
        }

        if(r<n && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest != index){
            swap(arr, largest, index);
            Heapify(arr, largest,n);
        }
    }


    private static void printArray(int[] arr) {
        for(int a : arr){
            System.out.print(a +" ");
        }
        System.out.println();
    }

}
