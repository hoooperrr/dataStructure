package com.dynamicProgramming;

public class longestPalindrome_5 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] p = new Boolean[n][n];
        int mid = n / 2;
        p[mid][mid]=true;
        for (int i = mid-1; i >= 0; i--) {
            for (int j = mid+1; j < n; j++) {
                p[i][j] = false;
//                if (Math.abs(i - j) < 2) {
//                    p[i][i] = true;
//                } else {
                if (j>i)
                    p[i][j] = p[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
//                }
            }
        }
        int i =0;
        int j = n - 1;
        for (i = 0; i < n; i++) {
            for (j = n - 1; j >= 0; j--) {
                if (p[i][j]) break;
            }
        }
        return s.substring(0, 0);
    }

    public static void main(String[] args) {
        String s = longestPalindrome("a");
        System.out.println(s);
    }
}
