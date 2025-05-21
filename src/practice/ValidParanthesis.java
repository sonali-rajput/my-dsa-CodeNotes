package practice;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

     public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValidPara(s));
    }

    public static boolean isValidPara(String s){

        HashMap<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length();i++){

            char c = s.charAt(i);

            if(!map.containsKey(c)){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    char top = stack.pop();
                    if(top == map.get(c)){
                        return true;
                    }
                }
            }

        }
        return stack.isEmpty();

    }
}
