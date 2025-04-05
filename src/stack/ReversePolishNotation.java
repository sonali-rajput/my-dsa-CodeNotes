package stack;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }


    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            if (isOPerator(token)) {
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                int result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

    private static boolean isOPerator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    
    private static int applyOperator(String operator,int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
