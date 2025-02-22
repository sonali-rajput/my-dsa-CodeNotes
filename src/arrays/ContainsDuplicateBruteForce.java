package arrays;

import java.util.Arrays;

// Sorting approach
// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicateBruteForce {

    public static void main (String[] args){
        int[] nums = {1,2,1,3};
        boolean ans = ContainsDuplicate(nums);
        System.out.println(ans);

    }
    public static boolean ContainsDuplicate(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        for(int i=0; i<nums.length; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

}
