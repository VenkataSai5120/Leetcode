class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return findMinTrials(k, n, dp);
    }
 
    private int findMinTrials(int k, int n, int[][] dp) {
        if (n == 0 || n == 1) return n;
        if (k == 1) return n;
        if (dp[k][n] != -1) return dp[k][n];
        int res = (int)1e9;
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int down = findMinTrials(k - 1, mid - 1, dp);
            int up = findMinTrials(k, n - mid, dp);
            res = Math.min(res, 1 + Math.max(up, down));

            if (down < up) low = mid + 1;
            else high = mid - 1;
        }

        return dp[k][n] = res;
    }
}