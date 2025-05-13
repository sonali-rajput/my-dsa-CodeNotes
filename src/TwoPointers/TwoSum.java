package TwoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum {

    public static void  main(String[] args){

        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left<right) {
            if ((numbers[left]+numbers[right]) > target) {
                right = right - 1;
            }
            else if (numbers[left]+numbers[right] < target) {
                left = left +1;
            }
            else {
                return new int[] {left+1,right+1};
            }
        }
        return null;

    }

}
