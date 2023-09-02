//word break
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        Set<String> set = new HashSet<>();
        for (String st : dictionary) set.add(st);
        return findMinExtra(s, set, 0, dp);
    }

    private int findMinExtra(String s, Set<String> set, int index, int[] dp) {
        if (index == s.length()) return 0;
        if (dp[index] != -1) return dp[index];
        int minExtra = (int)1e9;
        String st = "";

        for (int i = index; i < s.length(); i++) {
            st += s.charAt(i);
            int curr = set.contains(st) ? 0 : st.length();
            int fur = findMinExtra(s, set, i + 1, dp);
            minExtra = Math.min(minExtra, curr + fur);
        }

        return dp[index] = minExtra;
    }
}