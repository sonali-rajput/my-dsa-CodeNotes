package arraysandhashing;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
   
        if(s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        // frequency of each char in string s and t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }

        return true;
    }
}
