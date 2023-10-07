class Solution {
    int mod = 1_000_000_007;
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[51][51][101];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return findNumOfArrays(0, 0, 0, n, k, m, dp);
    }

    private int findNumOfArrays(int index, int cost, int max, 
    int n, int k, int m, int[][][] dp) {
        if (index == n) {
            return k == cost ? 1 : 0;
        }

        if (dp[index][cost][max] != -1) return dp[index][cost][max];

        long ways = 0;

        for (int i = 1; i <= m; i++) {
            int newCost = i > max ? cost + 1 : cost;
            int newMax = i > max ? i : max;
            ways = (ways + findNumOfArrays(index + 1, newCost, newMax, n, k, m, dp)) % mod;
        }

        return dp[index][cost][max] = (int)ways;
    }
}