package practice;

import java.util.HashSet;
import java.util.Stack;

public class EvalRPN {
public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens){

        if (tokens.length == 0){
            return 0;
        }

        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");


        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            if(!operators.contains(token)){
                stack.push(Integer.parseInt(token));
            }else {
                int b = stack.pop();
                int a = stack.pop();
                int result = calculate(token, b,a);
                stack.push(result);
            }
        }
        return stack.pop();
        
    }

        private static int calculate(String operator, int b, int a){
            switch (operator) {
                case "+": return a+b;
                case "-": return a-b;
                case "/": return a/b;
                case "*": return a*b;

                default: throw new IllegalArgumentException("Invalid operator");
            }
        }

}
