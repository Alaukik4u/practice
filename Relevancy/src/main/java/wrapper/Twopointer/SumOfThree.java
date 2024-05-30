package wrapper.Twopointer;

import java.util.Arrays;

public class SumOfThree{
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};

        System.out.println(findSumOfThree(nums, 24));
    }
        public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++){
            int newTarget = target - nums[i];
            int left=i+1, right = nums.length-1;

            while(left < right){
                if(nums[left] + nums[right] == newTarget){
                    return true;
                }else if(nums[left] + nums[right] > newTarget){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return false;
        }
}

