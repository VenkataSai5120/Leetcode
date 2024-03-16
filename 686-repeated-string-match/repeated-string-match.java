class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (a.equals(b)) return 1;
        int countRep = 1;
        String src = a;

        while (src.length() < b.length()) {
            src += a;
            countRep++;
        }

        int[] lps = findLPS(b);

        if (src.equals(b)) return countRep;
        if (searchPattern(src, b, lps)) return countRep;
        if (searchPattern(src + a, b, lps)) return countRep + 1;
        return -1;
    }

    private boolean searchPattern(String a, String b, int[] lps) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return j == b.length();
    }

    private int[] findLPS(String s) {
        int[] lps = new int[s.length()];
        int i = 1, j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}
