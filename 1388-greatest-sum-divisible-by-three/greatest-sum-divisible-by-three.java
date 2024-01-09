class Solution {
    public int solve(int index, int[] nums, int rem, int[][] dp) {
        if (index == nums.length) {
            if (rem == 0) return 0;
            return -100000000;
        }
        if (dp[index][rem] != -1) return dp[index][rem];

        int pick = nums[index] + solve(index + 1, nums, (rem + nums[index]) % 3, dp);
        int notPick = solve(index + 1, nums, rem, dp);
        return dp[index][rem] = Math.max(pick, notPick);
    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for (int[] a : dp) Arrays.fill(a, -1);
        return solve(0, nums, 0, dp);
    }
}