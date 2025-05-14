package arraysandhashing;

import java.util.Arrays;

public class ProductExceptItself {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductExceptItself obj = new ProductExceptItself();

        int[] ans = obj.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] productExceptSelf(int[] nums) {

        int[] results = new int[nums.length];

        Arrays.fill(results, 1);

        int prefix = 1, postfix = 1; // we considering the left and right side of the nums element to be 1. ex: 1,1,..1,2,3,4,1,1,1.. 

        for(int i = 0; i < nums.length; i++){
            results[i] = prefix;
            prefix = prefix*nums[i];
        }

        for(int i = nums.length - 1; i >=0; i--){ // go in reverse now
            results[i] = postfix*results[i]; // multiply with the result array elements
            postfix = postfix*nums[i]; // update the postfix
        }
        return results;
    }
}
