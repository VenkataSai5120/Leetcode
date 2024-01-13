class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] a1 : dp) Arrays.fill(a1, -1);
        return findMinSteps(n, 1, 1, dp) + 1;
    }

    private int findMinSteps(int n, int curr, int copied, int[][] dp) {
        if (curr == n) return 0;
        if (curr > n) return (int)1E9;
        if (dp[curr][copied] != -1) return dp[curr][copied];

        int copy = 1 + 1 + findMinSteps(n, 2 * curr, curr, dp);
        int notCopy = 1 + findMinSteps(n, curr + copied, copied, dp);
        return dp[curr][copied] = Math.min(copy, notCopy);
    }
}