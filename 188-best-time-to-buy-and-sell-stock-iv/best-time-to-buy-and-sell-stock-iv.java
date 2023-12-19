class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int[][] arr : dp) {
            for (int[] a : arr) Arrays.fill(a, -1);
        }
        return findMaxProfit(prices, 0, 1, k, dp);
    }

    private int findMaxProfit(int[] prices, int index, int isBuying, int k, int[][][] dp) {
        if (index == prices.length) return 0;
        if (k == 0) return 0;
        if (dp[index][isBuying][k] != -1) return dp[index][isBuying][k];
        int profit = 0;

        if (isBuying == 1 ) {
            profit = Math.max(-prices[index] + findMaxProfit(prices, index + 1, 0, k, dp), 
            findMaxProfit(prices, index + 1, 1, k, dp));
        }
        else {
            profit = Math.max(prices[index] + findMaxProfit(prices, index + 1, 1, k - 1, dp), 
            findMaxProfit(prices, index + 1, 0, k, dp));
        }

        return dp[index][isBuying][k] = profit;
    }
}