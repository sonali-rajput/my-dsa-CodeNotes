package slidingWindow;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {

        int[] occurance = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        for(; right<s.length();right++) {
            maxOccurance = Math.max(maxOccurance, ++occurance[s.charAt(right) - 'A']);
            if(right-left+1 - maxOccurance > k){ // len(substring) - maxOccurance(character) > k(operations)
                
                occurance[s.charAt(left) - 'A']--; //remove that char from the occrance array
                left++; // increment the left pointer
            }
            ans = Math.max(ans,right-left+1);
            
        }
        return ans;
    }

}
