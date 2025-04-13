package OA;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph,banned));

    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banned_words = new HashSet<>();
        HashMap<String, Integer> valid_word_counts = new HashMap<>();

        for (String banned_word: banned) {
            banned_words.add(banned_word);
        }

        String[] words = paragraph.toLowerCase().split("\\W+");

        for (String word: words) {
            if(!banned_words.contains(word)) {
                valid_word_counts.put(word, valid_word_counts.getOrDefault(word, 0) +1 );
            }
        }

        int max = 0;
        String result = "";

        for (String word: valid_word_counts.keySet()){
            if(valid_word_counts.get(word)>max){
                max = valid_word_counts.get(word);
                result = word;
            }
        }

        return result;

    }

}
