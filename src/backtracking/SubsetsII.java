package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubsetsII obj = new SubsetsII();
        List<List<Integer>> ans = obj.subsetsWithDup(nums);
        System.out.println(ans);
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
     
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start){
        result.add(new ArrayList<>(current)); // base casse

       
        for (int i=start; i<nums.length;i++) {
             // skip duplicates
            if(i>start && nums[i] == nums[i-1]) { // current elemetn is equals to the previous, we skip it
                continue;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() - 1); // backtrack
        }

    }
}
