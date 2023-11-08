class Solution {
    public int numDupDigitsAtMostN(int n) {
        String num  = Integer.toString(n);
        return n - findNoDup(num, num.length(), 0, 0, 0);
    }

    private int findNoDup(String num, int n, int index, int decider, int mask) {
        if (index == n) return mask == 0 ? 0 : 1;
        int res = 0;
        int limit = decider == 1 ? 9 : num.charAt(index) - '0';

        for (int i = 0; i <= limit; i++) {
            if ((mask & (1 << i)) != 0) continue;
            int newDecider = i < limit ? 1 : decider;
            int newMask = i == 0 && mask == 0 ? mask : mask | (1 << i);
            res += findNoDup(num, n, index + 1, newDecider, newMask);
        }

        return res;
    }
}