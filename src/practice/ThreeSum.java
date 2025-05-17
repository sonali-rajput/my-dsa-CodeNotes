package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){

        int left = 0;
        int right = nums.length - 1;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        while (left<right) {


            int k = Math.abs(nums[left]+nums[right]);

            if (left != right && !map.get(k).contains(left) && !map.get(k).contains(right)) {
                int sum = nums[left] + nums[right] + k;
                if(map.containsKey(k) && sum == 0){
                    List<Integer> indexes = map.get(k);
                    return new ArrayList<>(){nums[left], nums[right],k};

                }
                
                
            }
            
        left--;
        right++;
            
        }

        return null;



        
    }
}
