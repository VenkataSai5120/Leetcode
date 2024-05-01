class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int min = dfs(dungeon, dp, 0, 0);
        return min;
    }

    private int dfs(int[][] dungeon, int[][] dp, int x, int y) {
        if (dp[x][y] != 0){
            return dp[x][y];
        }

        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            dp[x][y] = dungeon[x][y] < 0 ? -dungeon[x][y] + 1 : 1;
            return dp[x][y];
        }

        int min = Integer.MAX_VALUE;
        
        if (x < dungeon.length - 1) {
            int down = dfs(dungeon, dp, x + 1, y);
            min = min < down ? min : down; 
        }
        
        if (y < dungeon[0].length - 1) {
            int right = dfs(dungeon, dp, x, y + 1);
            min = min < right ? min : right;
        }

        if (dungeon[x][y] >= min) {
            min = 1;
        }
        else {
            min = min - dungeon[x][y];
        }
        
        dp[x][y] = min;
        return min;
    }
}