package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> res = obj.combinationSum(candidates, target);
        System.out.println(res);
    
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // result = [[]]
        List<Integer> combination = new ArrayList<>(); // com = []
    
        backtrack(target, result, combination, 0, candidates); // 7,[[]], [],0,[2,3,6,7]
        return result;
        
    }

    private void backtrack(int target, List<List<Integer>> result, List<Integer> combination, int start, int[] candidates) {
        if(target == 0) {
            result.add(new ArrayList<>(combination));
        }
        else if(target<0){
            return;
        }

        // when target>0
        for(int i = start; i<candidates.length;i++) {
            combination.add(candidates[i]);
            backtrack(target-candidates[i], result, combination, i, candidates);
            combination.remove(combination.size() - 1);
        }
    }


}
