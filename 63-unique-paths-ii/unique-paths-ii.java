class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return findPaths(obstacleGrid, 0, 0, m, n, dp);
    }

    public int findPaths(int[][] og, int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 & j == n -1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if (i + 1 < m && og[i + 1][j] == 0) res += findPaths(og, i + 1, j, m, n, dp);
        if (j + 1 < n && og[i][j + 1] == 0) res += findPaths(og, i, j + 1, m, n, dp);
        return dp[i][j] = res;
    }
}