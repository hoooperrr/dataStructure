package com.points;

public class maxProfit_121 {
    public static int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//不持股 收益 最大
        dp[0][1] = prices[0];//持股 投资 最小

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] - dp[i - 1][1]);
            dp[i][1] = Math.min(dp[i - 1][1], prices[i]);
        }

        return dp[n - 1][0];

/*
        int i = 0;
        int j = prices.length - 1;
        while (i < j){
            while (prices[i]>prices[j])j--;

            while (prices[i]>prices[i+1])i++;

        }
*/
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int income = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i] && prices[j] - prices[i] > income) {
                    income = prices[j] - prices[i];
                }
            }
        }
        return income;
    }

    public static void main(String[] args) {
        int[] ints = {7, 6, 5, 8, 9, 10, 22, 1};
        System.out.println(maxProfit(ints));
    }
}
