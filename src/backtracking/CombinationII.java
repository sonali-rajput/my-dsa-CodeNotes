package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationII {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationII obj = new CombinationII();
        List<List<Integer>> ans = obj.combinationSum2(candidates, target);
        System.out.println(ans);
    }


     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;

    }

    public void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start){

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<candidates.length;i++) {

            // skip duplicates
            if(i>start && candidates[i] == candidates[i-1]) {
                continue;
            }

            // terminate if the sum becomes negative
            if(target - candidates[i] < 0){
                break;
            }

            current.add(candidates[i]);
            backtrack(result, current, candidates, target-candidates[i], i+1);  // target-candidates[i] to get the candidates[i] = 0 
            current.remove(current.size() - 1);
        }
    }
}
