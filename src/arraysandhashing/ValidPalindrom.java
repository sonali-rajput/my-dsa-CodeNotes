package arraysandhashing;

public class ValidPalindrom {


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        ValidPalindrom obj = new ValidPalindrom();

        boolean result = obj.isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {


        String lowerS = s.toLowerCase();
        String alphaS = lowerS.replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = alphaS.length() - 1;

        
        while (left < right) {

            if (alphaS.charAt(left) != alphaS.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
