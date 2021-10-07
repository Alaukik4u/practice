package DivideandConquer;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,8,3,7,12,34,21,54};

        printArray(arr);
        mergesort(arr,0, arr.length-1);
        printArray(arr);

    }

    private static void mergesort(int[] arr, int start, int end) {
        if(start<end){
            int mid = start + (end-start)/2;
            mergesort(arr, start, mid);
            mergesort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid-start+1;
        int n2 = end -mid;

        int[] la = new int[n1+1];
        int[] ra = new int[n2+1];


        for(int i=0; i<n1; i++){
            la[i] = arr[start+i];
        }

        for(int i=0; i<n2; i++){
            ra[i] = arr[mid+1+i];
        }

        la[n1] = Integer.MAX_VALUE;
        ra[n2] = Integer.MAX_VALUE;


        int i=0, j=0;

        for(int k=start; k<=end; k++){
            if(la[i] <=ra[j]){
                arr[k] = la[i];
                i++;
            }else{
                arr[k] = ra[j];
                j++;
            }
        }
    }

    private static void printArray(int[] arr) {
        for(int a : arr){
            System.out.print(a +" ");
        }
        System.out.println();
    }

}
