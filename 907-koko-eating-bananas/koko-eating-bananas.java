class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = -1;
        int res = 0;

        for (int p : piles) high = Math.max(p, high);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(piles, h, mid)) {
                high = mid - 1;
                res = mid;
            }
            else low = mid + 1;
        }

        return res;
    }

    public boolean isPossible(int[] piles, int hrs, int k) {
        int time = 0;

        for (int p : piles) {
            time += Math.ceil((double)p / k);
        }

        return time <= hrs;
    }
}