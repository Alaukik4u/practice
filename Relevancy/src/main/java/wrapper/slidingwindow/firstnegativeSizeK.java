package wrapper.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class firstnegativeSizeK {

    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int n = arr.length;
        int k = 3;

        printFirstNegativeInteger(arr, k, n);
    }

    private static void printFirstNegativeInteger(int[] arr, int k, int n) {
        if(n<k){
            System.out.println("invalid input");
            return;
        }

        int i=0, j=0, sum=0;
        List<Integer> list = new ArrayList<Integer>();
        while(j<n){
            if(arr[j] <0){
                list.add(arr[j]);
            }

            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(list.size() >0){
                    System.out.print(list.get(0)+" ");
                }else{
                    System.out.print(0+" ");
                }

                if(arr[i] < 0 && list.size()>0){
                    list.remove(0);
                }
                i++;
                j++;
            }
        }
    }
}
