package com.dataStructure.stack;

import java.util.*;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 11 + 5 * 6 - 2 /";
        System.out.println(getListString(suffixExpression));
        System.out.println(caculate(getListString(suffixExpression)));

        System.out.println("+++++++++++++++++++++");
        String expression = "1+((22+3)*4)-5";
        System.out.println(toInfixExpressionList(expression));
        System.out.println(parseSuffixExpression(toInfixExpressionList(expression)));
        System.out.println(caculate(parseSuffixExpression(toInfixExpressionList(expression))));


    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : split) {
            list.add(str);
        }
        return list;
    }

    public static int caculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                if (str.equals("-")) {
                    result = num2 - num1;
                } else if (str.equals("+")) {
                    result = num2 + num1;
                } else if (str.equals("*")) {
                    result = num1 * num2;
                } else if (str.equals("/")) {
                    result = num2 / num1;
                } else {
                    throw new RuntimeException("运算符error");
                }
                stack.push(String.valueOf(result));
//                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> toInfixExpressionList(String expression) {
        char[] expressionChars = expression.toCharArray();
//        System.out.println(expressionChars);
//        System.out.println(expressionChars.length);
        StringBuilder str = new StringBuilder();
        ArrayList<String> ls = new ArrayList<>();

        for (int i = 0; i < expressionChars.length; i++) {
            if (!Character.isDigit(expressionChars[i])) {
                ls.add(String.valueOf(expressionChars[i]));
            } else {
                str.append(expressionChars[i]);
                if (i == expressionChars.length - 1) {
                    ls.add(str.toString());
                } else {
                    if (!Character.isDigit(expressionChars[i + 1])) {
                        ls.add(str.toString());
                        str.replace(0, str.length(), "");
                    }
                }
            }

        }
        return ls;
    }

    public static List<String> parseSuffixExpression(List<String> expressionList) {
        Stack<String> stack1 = new Stack<>();
        ArrayList<String> array2 = new ArrayList<>();
        for (String str : expressionList) {
            if (str.matches("\\d+")) {
                array2.add(str);
            } else if (str.equals("(")) {
                stack1.push(str);
            } else if (str.equals(")")) {
                while (!stack1.peek().equals("(")) {
                    array2.add(stack1.pop());
                }
                stack1.pop();
            } else {
                while (stack1.size() != 0 && Operation.getValue(str) <= Operation.getValue(stack1.peek())) {
                    array2.add(stack1.pop());
                }
                stack1.push(str);
            }
        }
        while (stack1.size() != 0) {
            array2.add(stack1.pop());
        }
        return array2;
    }
}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符: " + operation);
                break;
        }
        return result;
    }

}
