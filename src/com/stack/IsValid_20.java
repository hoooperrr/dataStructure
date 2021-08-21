package com.stack;

import java.util.HashMap;
import java.util.Stack;

public class IsValid_20 {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (char c : chars) {
            if (characterStack.isEmpty()) {
                characterStack.push(c);
                continue;
            }
            char peek = characterStack.peek();
            characterStack.push(c);
            if (hashMap.containsKey(c) && peek == hashMap.get(c)) {
                characterStack.pop();
                characterStack.pop();
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
