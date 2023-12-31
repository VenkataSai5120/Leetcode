class Solution {
    int mod = (int)1e9 + 7;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[4001][k + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        return findWays(startPos, endPos, k, dp);
    }

    private int findWays(int start, int end, int k, int[][] dp) {
        if (k == 0) {
            return start == end ? 1 : 0;
        }

        if (dp[start + 2001][k] != -1) return dp[start + 2001][k];

        int right = findWays(start + 1, end, k - 1, dp);
        int left = findWays(start - 1, end, k - 1, dp);

        return dp[start + 2001][k] = (left + right) % mod;
    }
}