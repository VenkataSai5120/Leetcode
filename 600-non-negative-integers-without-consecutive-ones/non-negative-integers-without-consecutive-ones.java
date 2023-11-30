class Solution {
    int[][][] dp;

    public int f(int i, int prev, int constraint, String s) {
        int n = s.length();
        if (i >= n)
            return 1;

        if (dp[prev][constraint][i] != -1)
            return dp[prev][constraint][i];

        int answer = 0;
        int ub = constraint == 1 ? s.charAt(i) - '0' : 1;

        for (int x = 0; x <= ub; x++) {
            if (prev == 1) {
                if (x == 0)
                    answer += f(i + 1, x, (constraint & ((x == ub) ? 1 : 0)), s);
            } else {
                answer += f(i + 1, x, (constraint & ((x == ub) ? 1 : 0)), s);
            }
        }
        return dp[prev][constraint][i] = answer;
    }

    public int findIntegers(int n) {
        dp = new int[2][2][33];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        String s = sb.toString();
        int size = (int) (Math.log(n) / Math.log(2)) + 1;

        while (sb.length() < 32) {
            sb.insert(0, '0');
        }
        s = sb.substring(32 - size);

        int ans = f(0, 0, 1, s);
        return ans;
    }
}
