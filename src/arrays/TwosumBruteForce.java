package arrays;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/description/

public class TwosumBruteForce {


    public static void main (String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] ans = twoSum(nums,target);
        System.out.println(Arrays.toString(ans));  
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }

}