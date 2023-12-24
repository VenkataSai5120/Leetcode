class Solution {
    public int minOperations(String s) {
        int res1 = findMinOps(s.toCharArray(), 0);
        return Math.min(res1, s.length() - res1);
    }

    private int findMinOps(char[] arr, int curr) {
        int ops = 0;

        for (char c : arr) {
            if (c - '0' != curr) ops++;
            curr = 1 - curr;
        }

        return ops;
    }
}