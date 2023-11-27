class Solution {
    private static final int[][] possibleMoves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, 
    {0, 3, 7}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    private static final int mod = 1_000_000_007;

    public int findAllNums(int n, int curr, int[][] dp){
        if(n==0)
            return 1;
        if(dp[n][curr] != -1)
            return dp[n][curr];
        long ans = 0;
        for(int i: possibleMoves[curr]) {
            ans = (ans + findAllNums(n-1, i, dp)) % mod;
        }
        return dp[n][curr] = (int)ans;
    }
    
    public int knightDialer(int n) {
        long ans = 0;
        int[][] dp = new int[n+1][10];
        for (int[] a1 : dp) Arrays.fill(a1, -1);

        for(int i= 0; i < 10; i++){
            ans = (ans + findAllNums(n - 1, i, dp)) % mod;
        }
        return (int)ans;
    }
}