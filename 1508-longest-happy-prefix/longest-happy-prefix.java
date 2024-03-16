class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] kmp = new int[n + 1];

        for (int i = 1, j = 0; i < s.length();)
        if (s.charAt(i) == s.charAt(j)) 
            kmp[++i] = ++j;
        else {
            i += (j == 0) ? 1 : 0;
            j = kmp[j];
        }

        return s.substring(0, kmp[n]);
    }
}