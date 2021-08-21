package com.stack;

import java.util.Stack;

public class evalRPN_150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"18"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (String str : tokens) {
            if (isNumber(str)) {
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (str) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static Boolean isNumber(String token){
        if (token.matches("\\d+")){
            return true;
        }
        else if(token.matches("\\-\\d+|\\+\\d+")){
            return true;
        }else {
            return false;
        }
    }
}
