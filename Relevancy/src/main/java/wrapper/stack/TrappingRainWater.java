package wrapper.stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;

        System.out.print(maxWater(arr,n));
    }

    private static int maxWater(int[] arr, int n) {
        int leftArr[] = new int[arr.length];
        int rightArr[] = new int[arr.length];
        int trappedWater=0;

        int maxleft = Integer.MIN_VALUE;
        int maxright = Integer.MIN_VALUE;

        printArray(arr);
        for(int i=0; i<arr.length; i++){
            maxleft = Math.max(maxleft, arr[i]);
            leftArr[i] = maxleft;
        }
         printArray(leftArr);
        for(int i=arr.length-1; i>=0; i--){
            maxright = Math.max(maxright, arr[i]);
            rightArr[i] = Math.max(maxright, arr[i]);
        }
        printArray(rightArr);

        for(int i=0; i<arr.length; i++){
            trappedWater = trappedWater+(Math.min(leftArr[i], rightArr[i])-arr[i]);
        }

        return trappedWater;
    }


    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
