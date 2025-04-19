package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations obj = new LetterCombinations();
        List<String> ans = obj.letterCombinations(digits);
        System.out.println(ans);
    }


    // mapping of digits to letters
    private String[] digitsToLetters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        
        List<String> combinations = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return combinations;
        }

        backtrack(combinations, digits, "",0);
        return combinations;
        
    }

    private void backtrack(List<String> combinations, String digits, String currentCombination, int start) {
        

        // base case
        if(start == digits.length()){
            combinations.add(currentCombination);
            return;
        }

        String letters = digitsToLetters[digits.charAt(start) - '0'];
        for(char letter: letters.toCharArray()) {
            backtrack(combinations, digits, currentCombination+letter, start+1);
        }

    }
}
