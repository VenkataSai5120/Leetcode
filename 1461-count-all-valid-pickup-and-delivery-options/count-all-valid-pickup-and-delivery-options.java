//Fix one and try for remaining

class Solution {
    private static final int mod = 1_000_000_007;
    public int countOrders(int n) {
        // int[] dp = 
        return findWays(n);
    }

    private int findWays(int n) {
        if (n == 0) return 1;
        return (int)((2 * (long)n - 1) * n * findWays(n - 1) % mod);
    }
}