class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int ans = findMinCoins(coins, amount, coins.length - 1, dp);
        if (ans >= 1E9) return -1;
        return ans;
    }

    public int findMinCoins(int[] coins, int amount, int index, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return (int)1E9;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int notPick = findMinCoins(coins, amount, index - 1, dp);
        int pick = (int)1E9;
        if (coins[index] <= amount) pick = 1 + findMinCoins(coins, amount - coins[index], index, dp);
        return dp[index][amount] = Math.min(notPick, pick);
    }
}