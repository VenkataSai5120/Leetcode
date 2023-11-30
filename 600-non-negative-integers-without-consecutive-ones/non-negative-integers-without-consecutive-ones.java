class Solution {
    public int findIntegers(int n) {
        String num = Integer.toString(n, 2);
        int[][][] dp = new int[32][2][2];

        for (int [][] a1 : dp) {
            for (int[] a2 : a1) Arrays.fill(a2, -1);
        }

        return findNonCons(num, 0, 0, 0, dp);
    }

    private int findNonCons(String num, int index, int decider, int prev, int[][][] dp) {
        if (index == num.length()) return 1;
        if (dp[index][decider][prev] != -1) return dp[index][decider][prev];

        int res = 0;
        int limit = decider == 1 ? 1 : num.charAt(index) - '0';

        for (int i = 0; i <= limit; i++) {
            int newDecider = i < limit ? 1 : decider;
            
            if (prev == 1) {
                if (i == 0) {
                    res += findNonCons(num, index + 1, newDecider, i, dp);
                }
            }
            else {
                res += findNonCons(num, index + 1, newDecider, i, dp);
            }
        }

        return dp[index][decider][prev] = res;
    }
}