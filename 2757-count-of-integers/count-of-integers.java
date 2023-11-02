class Solution {
    private static final int mod = 1_000_000_007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int[][][] dp1 = new int[24][2][210];
        int[][][] dp2 = new int[24][2][210];
        for (int[][] a : dp1) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        for (int[][] a : dp2) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        int right = countGood(num2, num2.length(), 0, 0, min_sum, max_sum, dp1);
        int left = countGood(num1, num1.length(), 0, 0, min_sum, max_sum, dp2);
        int res = (right - left + mod) % mod;
        if (isLowGood(num1, min_sum, max_sum)) res = (int)(((long)res + 1) % mod);
        return res;
    }

    private boolean isLowGood(String num, int minSum, int maxSum) {
        int sum = 0;
        for (char c : num.toCharArray()) sum += Character.getNumericValue(c);
        return sum >= minSum && sum <= maxSum;
    }

    private int countGood(String num, int n, int decider, int sum, 
    int minSum, int maxSum, int[][][] dp) {
        if (n == 0) {
            return sum >= minSum && sum <= maxSum ? 1 : 0;
        }

        if (dp[n][decider][sum] != -1) return dp[n][decider][sum];

        int limit = decider == 1 ? 9 : num.charAt(num.length() - n) - '0';
        long res = 0;

        for (int i = 0; i <= limit; i++) {
            int newDecider = i < limit ? 1 : decider;
            res = (res + 
            countGood(num, n - 1, newDecider, sum + i, minSum, maxSum, dp)) % mod;
        }

        return dp[n][decider][sum] = (int)res;
    }
}