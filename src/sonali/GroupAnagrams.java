package sonali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        
        // create a hasmap
        HashMap<String,List> result = new HashMap<>();

        if (strs.length == 0) {
            return new ArrayList();
        }

        // create array for a-z (a=0,b=1,c=2 .. indexes)
        int[] countChar = new int[26];
        
        // loop through to store the word like: bat in the form of - 11000000000000000001000000 (string)
        for (String s: strs) {
            Arrays.fill(countChar,0);
            for (char c: s.toCharArray()){
                countChar[c - 'a']++;
            }

            // create sb to store the countChar strings char 11000 and so one
            StringBuilder sb = new StringBuilder();

            // loop to add the countChar as the key for our hashmap
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(countChar[i]);
            }
            String key = sb.toString();
            if(!result.containsKey(key)) {
                result.put(key, new ArrayList()); // if not present then we add the key to hashmap
            }
            result.get(key).add(s); 
        }

        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
