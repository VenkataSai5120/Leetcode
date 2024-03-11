class Solution {
    int[][] dp1;

    int isPalindrome(String s, int i, int j) {
        if (i >= j) return 1;
        if (dp1[i][j] != -1) return dp1[i][j];
        if (s.charAt(i) == s.charAt(j)) return dp1[i][j] = isPalindrome(s, i + 1, j - 1) == 1 ? 1 : 0;
        return dp1[i][j] = 0;
    }

    public boolean checkPartitioning(String s) {
        int n = s.length();
        dp1 = new int[n][n];
        for (int[] row : dp1) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (isPalindrome(s, 0, i) == 1 && isPalindrome(s, i + 1, j) == 1 && isPalindrome(s, j + 1, n - 1) == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
