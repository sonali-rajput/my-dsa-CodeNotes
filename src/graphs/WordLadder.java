package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class WordLadder {

    public static void main(String[] args) {

        WordLadder wl = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        
        int length = wl.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + length);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
    // all words are of same length
    int L = beginWord.length();
    
    // Dictionary to hold combination of words that can be formed, by changing one letter at a time
    Map<String, List<String>> allCombDict = new HashMap<>();
    
    // for all the words in wordList iterate over their chars
    wordList.forEach(word -> {
        for(int i=0; i<L; i++){
            // key is the generic word
            // Value is the list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
            List<String> transformations = allCombDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allCombDict.put(newWord, transformations);
        }
    });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair(beginWord, 1)); // add first word

    // Visted to check for loops/cycles
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);


    while (!Q.isEmpty()){
        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();
        for(int i=0; i<L; i++){

            // intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord: allCombDict.getOrDefault(newWord, new ArrayList<>())){
                // if we find the end word return ans
                if(adjacentWord.equals(endWord)){
                    return level+1;
                }

                // add it to bfs queue and mark it as visited
                if(!visited.containsKey(adjacentWord)){
                    visited.put(adjacentWord, true);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
    }
     return 0;

    }
}
