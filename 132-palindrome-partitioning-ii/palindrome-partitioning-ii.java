class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp1 = new int[n];
        int[][] dp2 = new int[n][n];
        for (int[] dp : dp2) Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        return findMinCuts(s.toCharArray(), 0, n, dp1, dp2) - 1;
    }

    public int findMinCuts(char[] s, int i, int n, int[] dp1, int[][] dp2) {
        if (i == n) return 0;
        int min = Integer.MAX_VALUE;
        if (dp1[i] != -1) return dp1[i];

        for (int ind = i; ind < n; ind++) {
            if (isPalin(s, i, ind, dp2) == 1) {
                min = Math.min(min, 1 + findMinCuts(s, ind + 1, n, dp1, dp2));
            }
        }

        return dp1[i] = min;
    }

    public int isPalin(char[] s, int i, int j, int[][] dp2) {
        if (i >= j) return 1;
        if (dp2[i][j] != -1) return dp2[i][j];
        if (s[i] == s[j]) return dp2[i][j] = isPalin(s, i + 1, j - 1, dp2);
        return dp2[i][j] = 0;
    }
}