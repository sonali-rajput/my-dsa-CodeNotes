package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }



    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length && nums[i] <= 0; i++ ) { // we loop through only negatives, thats why nums[i]<0

            // two sum using two pointers for finding j+k=target(that will be i+j+k=0, ex: i=-5, j+k=5
            if(i==0 || nums[i] != nums[i-1]) { // for ignoring duplicates in the nums array
                twoSum2(nums,i,result);
            }
        }
        return result;
    }

    static void twoSum2(int[] nums,int i, List<List<Integer>> result) {
        int left = i+1;
        int right = nums.length - 1;

        while(left<right) {
            int sum = nums[i] + nums[left] + nums[right]; // target is 0
            if(sum<0) {
                left++;
            }
            else if(sum >0) {
                right--;
            }
            else { // sum is exactly 0
                result.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                while(left<right && nums[left] == nums[left-1]) { // go throgh loop again to find another pair, until the adjacent values of left pointer are same.
                    ++left;
                }
            }
        }
    }

}
