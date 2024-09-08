class Solution {
    public boolean check(int[] start, int d, long mid) {
        long prev = start[0];
        for (int i = 1; i < start.length; i++) {
            long next = Math.max(prev + mid, start[i]);
            if (next > start[i] + d) {
                return false;
            }
            prev = next;
        }
        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        long low = 0, high = start[n - 1] - start[0] + d;
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(start, d, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }
}
