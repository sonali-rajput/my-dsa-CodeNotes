package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null; // is end
    public TrieNode(){}
}

public class WordSearchII {


    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
    
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
    
        String[] words = {"oath","pea","eat","rain","hike","flair"};
    
        List<String> result = ws.findWords(board, words);
    
        System.out.println("Found words: " + result);
    }

    char[][] fullboard = null;
    ArrayList<String> answer = new ArrayList<String>();


      public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root;
            for (Character letter: word.toCharArray()) {
                if(node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                }
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }

            node.word = word;
        }

        this.fullboard = board;
        for(int row=0; row<board.length;row++) {
            for(int col=0; col<board[0].length;col++) {
                if(root.children.containsKey(board[row][col])) {
                    backtracking(row,col,root);
                }
            }
        }
        return answer;
    }

    public void backtracking(int row, int col, TrieNode parent) {
        Character letter = fullboard[row][col];
        TrieNode currNode = parent.children.get(letter);

        if(currNode.word != null) { // it is a word
            this.answer.add(currNode.word);
            currNode.word = null;

        }
        fullboard[row][col] = '#'; // already visited we marking hash

        // iterate board [row][col] neighbours 
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int newRow = row+rowOffset[i];
            int newCol = col+colOffset[i];

            // check if newrow and newcol going out of bound or not
            if(newRow<0 || newCol < 0 || newRow >= fullboard.length || newCol >= fullboard[0].length){
                continue;
            }

            // we reach the correct neighbour, now we check if that neighbour is subsequent character we already stored in trie
            if(currNode.children.containsKey(fullboard[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        fullboard[row][col] = letter;

        // incrementaly remove the leaf node ( current node children is empty -> remove from parent)

        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

}

