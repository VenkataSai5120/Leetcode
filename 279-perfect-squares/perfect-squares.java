class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findMinSquares(n, dp);
    }

    private static int findMinSquares(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        int res = (int)1E9;

        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, 1 + findMinSquares(n - i * i, dp));
        }

        return dp[n] = res;
    }
}