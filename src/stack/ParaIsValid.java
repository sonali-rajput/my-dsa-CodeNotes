package stack;

import java.util.HashMap;
import java.util.Stack;

public class ParaIsValid {


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){


        HashMap<Character, Character> mappedChar = new HashMap<>();

        mappedChar.put(')','(');
        mappedChar.put('}','{');
        mappedChar.put(']','[');

        Stack<Character> stak = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(!mappedChar.containsKey(c)) {
                stak.push(c);
            }
            else {
                if(stak.isEmpty()) {
                    return false;
                }
                char topElement = stak.pop();
                if(topElement!=mappedChar.get(c)){
                    return false;
                }
            }
        }
        return stak.isEmpty();

    }

}
