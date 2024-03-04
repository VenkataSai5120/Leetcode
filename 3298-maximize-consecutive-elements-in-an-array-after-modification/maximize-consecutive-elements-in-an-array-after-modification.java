class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[1000002];
        int maxSelected = 0;

        for (int ele : nums) {
            dp[ele + 1] = 1 + dp[ele];
            dp[ele] = 1 + dp[ele - 1];
            // System.out.println(Arrays.toString(dp));
        }

        for (int res : dp) {
            maxSelected = Math.max(maxSelected, res);
        }

        return maxSelected;
    }
}