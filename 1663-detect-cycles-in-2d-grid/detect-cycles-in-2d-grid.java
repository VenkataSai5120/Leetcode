class Solution {
    private static final int[] DIR_X = {1, -1, 0, 0};
    private static final int[] DIR_Y = {0, 0, 1, -1};
    
    private boolean dfs(int curX, int curY, int lastX, int lastY, int n, int m, boolean[][] vis, char[][] grid, char startChar) {
        vis[curX][curY] = true;
        
        for (int i = 0; i < 4; ++i) {
            int newX = curX + DIR_X[i];
            int newY = curY + DIR_Y[i];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                if (!(newX == lastX && newY == lastY)) {
                    if (grid[newX][newY] == startChar) {
                        if (vis[newX][newY] || 
                        dfs(newX, newY, curX, curY, n, m, vis, grid, startChar)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (!vis[i][j] && dfs(i, j, -1, -1, n, m, vis, grid, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
