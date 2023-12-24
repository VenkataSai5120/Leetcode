class Solution {
    public int minOperations(String s) {
        return Math.min(findMinOps(s.toCharArray(), 0), findMinOps(s.toCharArray(), 1));
    }

    private int findMinOps(char[] arr, int curr) {
        int ops = 0;

        for (char c : arr) {
            if (c - '0' != curr) ops++;
            curr = 1 - curr;
        }

        return ops
        ;
    }
}