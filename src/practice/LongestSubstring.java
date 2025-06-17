package practice;

import java.util.HashSet;

public class LongestSubstring {

public static void main(String[] args) {
    String s = "abatman";

    System.out.println(longestSubStr(s));
}
    public static int longestSubStr(String s){


        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < s.length()){ // 6<7

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right)); // set = t,m,a,n
                right++; // r = 7
            }
            else {
                
                set.remove(s.charAt(left)); // set = ,t,m
                left++; // l = 3
            }
            ans = Math.max(ans,set.size()); // ans = 4
            
        }
        return ans;

    }
}
