package advanceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"ba","by","ad","alt","ai","air"};

        AlienDictionary obj = new AlienDictionary();
        String res = obj.alienOrder(words);
        System.out.println(res);
    }
    
    public Map<Character, List<Character>> reversedList = new HashMap<>(); // reversed list cuz we are reversing the adjancency list.
    public Map<Character, Boolean> seen = new HashMap<>();
    public StringBuilder result = new StringBuilder();

    public String alienOrder(String[] words){

        // find unique chars in words
        for(String word: words){
            for(char c: word.toCharArray()){
                reversedList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Find all the edges and add in hashmap
        for(int i=0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2= words[i+1];

            // check whether word1 is prefix of word2 or not
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            // Find first differing char in those two words and add it to hashMap
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    reversedList.get(word2.charAt(j)).add(word1.charAt(j));
                    break; // come out of that particular word when first differing char has been found
                }
            }
        }

        // iterate over hashMap (reversedList) DFS
        for(Character c: reversedList.keySet()){
            boolean res = dfs(c);
            if(!res) return "";
        }

        // check if all the unique chars present
        if(result.length() < reversedList.size()){
            return "";
        }
        return result.toString();
    }

    public boolean dfs(Character c){

        // check if already visited
        if(seen.containsKey(c)){
            return seen.get(c);
        }
        seen.put(c, false);
        
        for(Character next: reversedList.get(c)){
            boolean res = dfs(next);
            if(!res) return false;
        }

        seen.put(c, true);
        result.append(c);
        return true;
    }

}
