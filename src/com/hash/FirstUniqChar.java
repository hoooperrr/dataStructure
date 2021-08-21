package com.hash;

import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int index = -1;
        char[] chars = s.toCharArray();

        HashMap<Character, Integer> ci = new HashMap<>();
        for (int a = 0; a < chars.length; a++) {
            System.out.println(chars[a]);
            ci.put(chars[a], a);
        }
        for (int a = 0; a < chars.length; a++) {
            System.out.println(chars[a]);
            System.out.println(!ci.containsKey(chars[a]));
            if (!ci.containsKey(chars[a])) {
                return ci.get(chars[a]);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "eeep";
        System.out.println(new FirstUniqChar().firstUniqChar(s));
    }
}
