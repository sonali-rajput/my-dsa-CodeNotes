package tries;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
    public TrieNode() {}
}

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println(dictionary.search("pad")); // false
        System.out.println(dictionary.search("bad")); // true
        System.out.println(dictionary.search(".ad")); // true
        System.out.println(dictionary.search("b..")); // true
        System.out.println(dictionary.search("..d")); // true
        System.out.println(dictionary.search("b.d")); // true
        System.out.println(dictionary.search("b..e")); // false
    }

    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for (char ch: word.toCharArray()){
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode()); // add that character in the Trienode (hashmap)
            }
            node = node.children.get(ch); // move on to the next node
        }
        node.word = true;
        
    }

    public boolean searchInNode(String word, TrieNode node) { // helper method for searching

        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                if(ch == '.') {
                    for(char x: node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if(searchInNode(word.substring(i+1), child)){ // next character ( as we skipping .)
                            return true;
                        }
                    }
                }
                else {
                    return false;
                }
            }
            else {
                node = node.children.get(ch); // iterate over the next value
            }
        }
        return node.word;
    }
    
    public boolean search(String word) {

        return searchInNode(word, trie);
        
    }

}
