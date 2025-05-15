package arraysandhashing;

import java.util.HashSet;

public class LongestSuSeq {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int longestSub = 1;

        for(int num: nums){
            if(set.contains(num-1)){
                continue; // we check if ex 100-1 = 99 present in hashset 
            }
            else {
                int currentNum = num;
                int currentSub = 1; // current sub sequence
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }
                longestSub = Math.max(longestSub, currentSub);
            }
        }
        return longestSub;
        
    }
}
