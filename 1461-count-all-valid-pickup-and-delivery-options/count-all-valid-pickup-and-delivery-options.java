//Fix one and try for remaining

class Solution {
    private static final int mod = 1_000_000_007;
    public int countOrders(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findWays(n, dp);
    }

    private int findWays(int n, int[] dp) {
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = (int)((2 * (long)n - 1) * n * findWays(n - 1, dp) % mod);
    }
}