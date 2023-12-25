class Solution {
    public int numDecodings(String s) {
        return s.length() == 0 ? 0 : numWays(s, 0, new Integer[s.length()]);
    }
    
    public int numWays(String s, int index, Integer[] dp) {
        int n = s.length();
        
        if (index == n) return 1;
        
        if (s.charAt(index) == '0') return 0;
        
        if (dp[index] != null) return dp[index];
        
        int res = numWays(s, index + 1, dp);
        if (index < n - 1 && (s.charAt(index) == '1' || s.charAt(index) == '2' 
        && s.charAt(index + 1) < '7')) res += numWays(s, index + 2, dp);
        return dp[index] = res;
    }
}