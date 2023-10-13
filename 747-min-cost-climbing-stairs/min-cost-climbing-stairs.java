class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return findMinCost(cost, cost.length, dp);
    }

    private int findMinCost(int[] cost, int step, int[] dp) {
        if (step == 0 || step == 1) return 0;
        if (dp[step] != -1) return dp[step];
        return dp[step] = Math.min(findMinCost(cost, step - 1, dp) + cost[step - 1], 
        findMinCost(cost, step - 2, dp) + cost[step - 2]);
    }
}