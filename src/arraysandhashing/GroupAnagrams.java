package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> ansMap = new HashMap<>();

        if (strs.length == 0){
            return new ArrayList<>();
        }

        int[] count = new int[26];

        for(String s: strs){
            Arrays.fill(count, 0);

            for(Character c: s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<strs.length; i++){
                sb.append('#');
                sb.append(count[i]);
            }
    
            String key = sb.toString();
    
            if(!ansMap.containsKey(key)){
                ansMap.put(key, new ArrayList<>());
            }
    
            ansMap.get(key).add(s);
        }

        return new ArrayList(ansMap.values());
        
    }
}
