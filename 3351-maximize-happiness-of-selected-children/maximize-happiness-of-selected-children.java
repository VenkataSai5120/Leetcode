class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int decBy = 0;
        long totalHappiness = 0;

        for (int i = happiness.length - 1; i >= 0 && k > 0; i--) {
            totalHappiness += Math.max(0, happiness[i] - decBy);
            decBy++;
            k--;
        }

        return totalHappiness;
    }
}