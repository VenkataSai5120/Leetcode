class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        if (d > n) return -1;
        
        int[][] dp = new int[n][d + 1];
        
        for (int[] arr : dp) Arrays.fill(arr, - 1);
        
        return minDiff(jobDifficulty, d, n, 0, dp);
    }
    
    public int minDiff(int[] jd, int d, int n, int index, int[][] dp) {
        
        if (d == 0) {
            if (index == n) return 0;
            else return Integer.MAX_VALUE;
        }
        
        if (index == n) {
            if (d == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        
        if (dp[index][d] != -1) return dp[index][d];
        
        long currMax = 0;
        long res = Integer.MAX_VALUE;
        
        for (int i = index; i < n; i++) {
            currMax = Math.max(currMax, jd[i]);
            res = Math.min(res, currMax + minDiff(jd, d - 1, n, i +  1, dp));
        }
        
        return dp[index][d] = (int)res;
    }
}