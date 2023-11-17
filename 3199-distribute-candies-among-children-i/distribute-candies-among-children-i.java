class Solution {
    public int distributeCandies(int n, int limit) {
        return findWays(n, 0, limit);
    }

    private int findWays(int n, int child, int limit) {
        if (child == 3) {
            if (n == 0) return 1;
            return 0;
        }
        int res = 0;

        for (int i = 0; i <= limit; i++) {
            res += findWays(n - i, child + 1, limit);
        }   

        return res;
    }
}