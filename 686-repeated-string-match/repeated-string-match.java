class Solution {
    int mod = 100000;
    public int repeatedStringMatch(String a, String b) {
        if (a.equals(b)) return 1;
        int countRep = 1;
        String src = a;

        while (src.length() < b.length()) {
            src += a;
            countRep++;
        }

        if (src.equals(b)) return countRep;
        if (searchPattern(src, b)) return countRep;
        if (searchPattern(src + a, b)) return countRep + 1;
        return -1;
    }
    private boolean searchPattern(String src, String tar) {
        int n = src.length(), m = tar.length();
        int currHash = 0;
        int targetHash = 0;
        int rollingPow = 1;

        for (int i = 0; i < m; i++) rollingPow = (rollingPow * 26) % mod;

        for (int i = 0; i < m; i++) targetHash = (targetHash * 26 + tar.charAt(i)) % mod;

        for (int i = 0; i < n; i++) {
            currHash = (currHash * 26 + src.charAt(i)) % mod;
            if (i < m - 1) continue;
            if (i >= m) currHash = (currHash - src.charAt(i - m) * rollingPow) % mod;
            // System.out.println(currHash);
            if (currHash < 0) currHash += mod;
            if (targetHash == currHash) {
                if (src.substring(i - m + 1, i + 1).equals(tar)) return true;
            }
        }

        return false;
    }

}