class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return isMatch(s, p, 0, 0, dp);
    }

    private boolean isMatch(String s, String p, int i, int j, Boolean[][] dp) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (i == s.length() && j != p.length()) {
            if (isAllStars(p, j)) return true;
            return false;
        }

        if (j == p.length()) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean pos1 = false, pos2 = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return isMatch(s, p, i + 1, j + 1, dp);
        }

        if (p.charAt(j) == '*') pos2 = isMatch(s, p, i + 1, j, dp) || isMatch(s, p, i, j + 1, dp);

        return dp[i][j] = pos1 || pos2;
    }

    private boolean isAllStars(String s, int j) {
        while (j < s.length()) {
            if (s.charAt(j) != '*') return false;
            j++;
        }

        return true;
    }
}