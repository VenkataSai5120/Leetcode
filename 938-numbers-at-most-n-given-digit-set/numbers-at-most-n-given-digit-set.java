class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = Integer.toString(n);
        int[][][] dp = new int[10][2][10];
        for (int[][] a : dp) {
            for (int[] b : a) Arrays.fill(b, -1);
        }
        return findNums(num.toCharArray(), 0, 0, 0, digits, dp) - 1; // -1 to avoid zero
    }

    private int findNums(char[] num, int index, int decider, int prevDig, 
    String[] digits, int[][][] dp) {
        if (index == num.length) return 1;
        if (dp[index][decider][prevDig] != -1) return dp[index][decider][prevDig];

        int res = 0;
        int limit = decider == 1 ? digits[digits.length - 1].charAt(0) - '0' : num[index] - '0';

        if (prevDig == 0) res += findNums(num, index + 1, 1, prevDig, digits, dp);

        for (String dig : digits) {
            int d = Integer.parseInt(dig);
            if (d > limit) break;
            int newDecider = d < limit ? 1 : decider;
            res += findNums(num, index + 1, newDecider, d, digits, dp);
        }

        return dp[index][decider][prevDig] = res;
    }
}