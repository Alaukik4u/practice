package wrapper.DivideandConquer;

public class InsertionSort {


        public static void main(String[] args) {
            int[] arr = new int[]{1,4,5,8,3,7};

            printArray(arr);
            insertionsort(arr);
            printArray(arr);

        }

        private static void insertionsort(int[] arr) {

            for(int j=1; j<arr.length; j++){
                int key = arr[j];
                int i=j-1;

                while(i>0 && arr[i] > key){
                    arr[i+1] = arr[i];
                    i--;
                }
                arr[i+1] = key;
            }

        }



        private static void printArray(int[] arr) {
            for(int a : arr){
                System.out.print(a +" ");
            }
            System.out.println();
        }

}
