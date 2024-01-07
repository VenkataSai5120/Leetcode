class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] dp = new HashMap[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                int countPrev = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + countPrev + 1);
                res += countPrev;
            }
        }

        return res;
    }
}