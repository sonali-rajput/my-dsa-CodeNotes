package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation obj = new Permutation();
        int[] nums = {1,2,3};
        List<List<Integer>> res = obj.permute(nums);
        System.out.println(res); 
    }


       public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

       private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {

        // base case
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =0; i < nums.length; i++){
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(result, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1); // backtrack
            }
        }
         
       }


}
