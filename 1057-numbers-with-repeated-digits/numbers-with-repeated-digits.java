class Solution {
    public int numDupDigitsAtMostN(int n) {
        String num  = Integer.toString(n);
        int[][][] dp = new int[num.length()][2][1 << 10];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return n - findNoDup(num, num.length(), 0, 0, 0, dp);
    }

    private int findNoDup(String num, int n, int index, int decider, int mask, int[][][] dp) {
        if (index == n) return mask == 0 ? 0 : 1;
        if (dp[index][decider][mask] != -1) return dp[index][decider][mask];
        int res = 0;
        int limit = decider == 1 ? 9 : num.charAt(index) - '0';

        for (int i = 0; i <= limit; i++) {
            if ((mask & (1 << i)) != 0) continue;
            int newDecider = i < limit ? 1 : decider;
            int newMask = i == 0 && mask == 0 ? mask : mask | (1 << i);
            res += findNoDup(num, n, index + 1, newDecider, newMask, dp);
        }

        return dp[index][decider][mask] = res;
    }
}