class Solution {
    public int countDigitOne(int n) {
        String num = Integer.toString(n);
        int[][][] dp = new int[num.length()][2][10];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return countOnes(num, 0, 0, 0, num.length(), dp);
    }

    private int countOnes(String num, int index, int decider, int count, int n, int[][][] dp) {
        if (index == n) return count;
        if (dp[index][decider][count] != -1) return dp[index][decider][count];
        int ones = 0;
        int limit = decider == 1 ? 9 : num.charAt(index) - '0';
        int res = 0;

        for (int i = 0; i <= limit; i++) {
            if (i == 1) ones++;
            int newCount = i == 1 ? count + 1 : count;
            int newDecider = i < limit ? 1 : decider;
            res += countOnes(num, index + 1, newDecider, newCount, n, dp);
        }

        return dp[index][decider][count] = res;
    }
}