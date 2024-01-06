class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Integer> endTimeProfit = new TreeMap<>();
        endTimeProfit.put(0, 0);

        for (int[] job : jobs) {
            int currProfit = job[2] + endTimeProfit.floorEntry(job[0]).getValue();
            if (currProfit > endTimeProfit.lastEntry().getValue()) {
                endTimeProfit.put(job[1], currProfit);
            }
        }

        return endTimeProfit.lastEntry().getValue();
    }
}