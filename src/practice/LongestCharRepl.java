package practice;

public class LongestCharRepl {


    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(replaceChar(s, k));
    }

    public static int replaceChar(String s, int k){


        int left = 0, right = 0, ans = 0, count = 0;

        while(right < s.length()){

            if(s.charAt(left)!=s.charAt(right) && count<k){
                char rchar = s.charAt(right);
                char l = s.charAt(left);
                rchar = l;
                count++;
                right++;
                
            }
            else {
                right++;
            }
            ans = Math.max(ans, right-left);

        }

        return ans;
    }
}
