package wrapper.Arrays;

import static wrapper.stack.TrappingRainWater.printArray;

public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        printArray(nums);
        rotate(nums, 2);
        printArray(nums);
    }

    private static void rotate(int[] nums, int k) {

        if(k == 0)
            return;
        int size =nums.length-1;
        k = (k % size);

        rotateArray(nums, 0, k-1);
        rotateArray(nums, k, size);
        rotateArray(nums, 0, size);

    }

    private static void rotateArray(int[] nums, int start, int end) {
        int temp;

        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
