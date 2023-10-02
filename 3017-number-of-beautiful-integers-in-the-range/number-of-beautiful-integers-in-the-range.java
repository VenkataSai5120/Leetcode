class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String h = Integer.valueOf(high).toString();
        String l = Integer.valueOf(low - 1).toString();
        int[][][][][][] dp = new int[11][2][2][11][11][k + 1];

        for (int[][][][][] a : dp) {
            for (int[][][][] b : a) {
                for (int[][][] c : b) {
                    for (int[][] d : c) {
                        for (int[] e : d) {
                            Arrays.fill(e, -1);
                        }
                    }
                }
            }
        }

        int higher = count(h, h.length(), 0, 1, 0, 0, 0, k, dp);

        for (int[][][][][] a : dp) {
            for (int[][][][] b : a) {
                for (int[][][] c : b) {
                    for (int[][] d : c) {
                        for (int[] e : d) {
                            Arrays.fill(e, -1);
                        }
                    }
                }
            }
        }

        int lower = count(l, l.length(), 0, 1, 0, 0, 0, k, dp);
        return higher - lower;
    }

    private int count(String num, int size, int decider, int isLeading, 
    int even , int odd, int rem, int k, int[][][][][][] dp) {
        if (size == 0) {
            if (even == odd && rem == 0) return 1;
            return 0;
        }

        if (dp[size][decider][isLeading][even][odd][rem] != -1) 
        return dp[size][decider][isLeading][even][odd][rem];

        int limit = decider == 0 ? num.charAt(num.length() - size) - '0' : 9;
        int res = 0;

        for (int digit = 0; digit <= limit; digit++) {
            int newDecider = decider;
            if (digit < limit) newDecider = 1;

            if (isLeading == 1 && digit == 0) {
                res += count(num, size - 1, newDecider, 
                isLeading & (digit == 0 ? 1 : 0), 0, 0, 0, k, dp);
            }
            else {
                if (digit % 2 == 0) {
                    res += count(num, size - 1, newDecider, 0, even + 1, odd, 
                    (rem * 10 + digit) % k, k, dp);
                }
                else {
                    res += count(num, size - 1, newDecider, 0, even, odd + 1, 
                    (rem * 10 + digit) % k, k, dp);
                }
            }
        }

        return dp[size][decider][isLeading][even][odd][rem] = res;
    }
}