package practice;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        TwoSum obj = new TwoSum();
        int[] ans = obj.twoSum(nums, 13);
        System.out.println(Arrays.toString(ans));
    }

    public int[] twoSum(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left]+nums[right] > target){
                right--;
            }
            else if (nums[left]+nums[right] < target) {
                left++;
            }
            else {
                return new int[] {left+1, right+1};
            }
            // left++;
            // right--;
        }

        return null;


    }
}
