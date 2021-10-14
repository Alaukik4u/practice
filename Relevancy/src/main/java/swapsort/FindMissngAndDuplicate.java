package swapsort;

import static DivideandConquer.HeapSort.swap;
import static stack.TrappingRainWater.printArray;

public class FindMissngAndDuplicate {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 3, 2, 1, 1 };

        findMissngAndDuplicate(arr);
    }

    private static void findMissngAndDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i] != arr[arr[i]-1]){
               swap(arr, i, arr[i]-1);
            }else{
                i++;
            }
        }

        printArray(arr);

        for(i=0; i<arr.length;i++){
            if(arr[i]!=i+1){
                System.out.println("missing number ::"+(i+1));
                System.out.println("duplicate number ::"+(arr[i]));
            }

        }
    }
}