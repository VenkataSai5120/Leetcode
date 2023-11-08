class Solution {
    int M = 1000000007;
    char[] es; // evil string
    long[][][] dp;
    int[] next;
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        es = evil.toCharArray();
		// build kmp next array
        next = new int[es.length];
        next[0] = -1;
        for (int i = 1, j = 0; i < es.length; i++) {
            next[i] = es[i] == es[j] ? -1 : j;
            while (j >= 0 && es[i] != es[j]) j = next[j];
            j++;
        }
        System.out.println(Arrays.toString(next));
        long pre = solve(s1), ans = (solve(s2) - pre + M) % M;
        if (s1.indexOf(evil) == -1) ans++;
        return (int) (ans % M);
    }
    char[] ds; // ori digit string
    long solve(String digits) {
        dp = new long[digits.length()][es.length][2];
        ds = digits.toCharArray();
        return dfs(0, 0, true);
    }
    long dfs(int idx, int eidx, boolean limit) {
        if (eidx == es.length) return 0;
        if (idx == ds.length) return 1;
        if (dp[idx][eidx][limit?1:0] > 0) return dp[idx][eidx][limit?1:0];
        int max = limit ? ds[idx] : 'z';
        long res = 0;
        for (int i = 'a'; i <= max; i++) {
            int tmp = eidx;
			// use kmp next array to find next evil string idx position
            while (tmp >= 0 && es[tmp] != i) tmp = next[tmp];
            res += dfs(idx + 1, tmp + 1, limit && (i == max));
            res %= M;
        }
        return dp[idx][eidx][limit?1:0] = res;
    }
}