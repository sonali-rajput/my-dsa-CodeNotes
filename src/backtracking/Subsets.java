package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = obj.subsets(nums);
        System.out.println(ans);
    }



     public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0,nums, new ArrayList<>(),result);
        return result;
    }

    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i=index; i<nums.length; i++){
            current.add(nums[i]);
            generateSubsets(i+1, nums, current, result);
            current.remove(current.size()-1); // for ex we done visiting first element so we remove one element from the array
        }
    }
}
