class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = findLPS(needle);
        int i = 0, j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }

        if (j == needle.length()) return i - j;
        return -1;
    }

    private int[] findLPS(String pat) {
        int[] lps = new int[pat.length()];
        int j = 0;

        for (int i = 1; i < pat.length();) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            }
            else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }

        return lps;
    }
}