class Solution {
    int[] cumSum;
    Random random;

    public Solution(int[] w) {
        this.cumSum = new int[w.length];
        this.random = new Random();
        cumSum = w;

        for (int i = 1; i < w.length; i++) {
            cumSum[i] += cumSum[i - 1];
        }
    }
    
    public int pickIndex() {
        int val = random.nextInt(cumSum[cumSum.length - 1]) + 1;
        int low = 0, high = cumSum.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (cumSum[mid] == val) {
                return mid;
            }
            else if (cumSum[mid] > val) {
                high--;
            }
            else {
                low++;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */