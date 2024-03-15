class Solution {
    private final int[] dirX = {1, -1, 0, 0};
    private final int[] dirY = {0, 0, 1, -1};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && isCycleDetected(i, j, -1, -1, grid[i][j], grid, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean isCycleDetected(int r, int c, int pr, int pc, char currC, 
    char[][] grid, boolean[][] vis) {
        vis[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int newR = r + dirX[k], newC = c + dirY[k];
            if (Math.min(newR, newC) < 0 || newR >= grid.length || newC >= grid[0].length 
            || grid[newR][newC] != currC) {
                continue;
            }

            if (newR != pr && newC != pc && vis[newR][newC]) {
                return true;
            }

            if (!vis[newR][newC] && isCycleDetected(newR, newC, r, c, currC, grid, vis)) {
                return true;
            }
        }

        return false;
    }
}