class Solution {
    public int countSpecialNumbers(int n) {
        String num = Integer.toString(n);
        int[][][] dp = new int[11][2][(1 << 11) - 1];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return countDistinct(num.toCharArray(), num.length(), 0, 0, dp);
    }

    private int countDistinct(char[] num, int n, int decider, int mask, int[][][] dp) {
        if (n == 0) return mask == 0 ? 0 : 1;
        if (dp[n][decider][mask] != -1) return dp[n][decider][mask];
        int res = 0;
        int limit = decider == 1 ? 9 : num[num.length - n] - '0';

        for (int i = 0; i <= limit; i++) {
            if ((mask & (1 << i)) != 0) continue;
            int newDecider = i < limit ? 1 : decider;
            int newMask = mask == 0 && i == 0 ? mask : mask | (1 << i);
            res += countDistinct(num, n - 1, newDecider, newMask, dp);
        }

        return dp[n][decider][mask] = res;
    }
}