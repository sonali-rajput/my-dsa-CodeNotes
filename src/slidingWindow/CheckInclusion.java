package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        
        for(char c: s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> map2 = new HashMap<>();

        int windowSize = s1.length();

        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch,0)+1);

            // Shrink the window from the left if size exceeds s1.length()
            if(i>=windowSize){
                char leftChar = s2.charAt(i - windowSize);
                if(map2.get(leftChar) == 1) {
                    map2.remove(leftChar); // remove completely if it was only once

                } else {
                    map2.put(leftChar, map2.get(leftChar)-1); // just decrease count
                }
            }

            if(map1.equals(map2)) return true;
        }
        return false;
    }

}
