package com.dataStructure.stack;

import java.util.Stack;

public class ValidateStackSequences_JZ31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int elem : pushed) {
            stack.push(elem);
//                while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
//                    stack.pop();
//                    i++;
//                }
//            while (i < popped.length && popped[i] == elem) {
//                stack.pop();
//                i++;
//            }
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == popped.length;
//        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 0};
        int[] b = new int[]{1, 2, 0};
        ValidateStackSequences_JZ31 v = new ValidateStackSequences_JZ31();
        boolean b1 = v.validateStackSequences(a, b);
        System.out.println(b1);
    }
}
