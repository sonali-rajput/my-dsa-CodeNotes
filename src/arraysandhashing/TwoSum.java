package arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        
        int[] num = {3,3};
        TwoSum obj = new TwoSum();

        int[] ans = obj.twoSum(num, 6);
        System.out.println(Arrays.toString(ans));
    }

    public int[] twoSum(int[] num, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < num.length; i++) {
            
            int next = target - num[i];
            if (map.containsKey(next)){
                return new int[]{i, map.get(next)};
            }
            map.put(num[i], i);
        }
        return null;
    }

}
