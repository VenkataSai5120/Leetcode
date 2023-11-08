class Solution {
    Set<Integer> validDigits = new HashSet<>(Arrays.asList(0, 1, 2, 5, 6, 8, 9));
    public int rotatedDigits(int n) {
        String num = Integer.toString(n);
        int len = num.length();
        int[][][] dp = new int[n][2][1 << 10];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return findGood(num, 0, 0, 0, len, dp);
    }

    private int findGood(String num, int index, int decider, int mask, int n, int[][][] dp) {
        if (index == n) {
            if((mask & (1 << 2)) != 0 || (mask & (1 << 5)) != 0 ||
            (mask & (1<<6)) != 0 || (mask & (1 << 9)) != 0) return 1;
            return 0;
        }

        if (dp[index][decider][mask] != -1) return dp[index][decider][mask];

        int res = 0;
        int limit = decider == 0 ? num.charAt(index) - '0' : 9;

        for (int i = 0; i <= limit; i++) {
            if (!validDigits.contains(i)) {
                continue;
            }

            int newDecider = i < limit ? 1 : decider;
            res += findGood(num, index + 1, newDecider, mask | (1 << i), n, dp);
        }

        return dp[index][decider][mask] = res;
    }
}