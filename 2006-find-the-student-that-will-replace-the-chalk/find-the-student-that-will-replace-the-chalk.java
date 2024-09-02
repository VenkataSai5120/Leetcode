class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n];
        preSum[0] = chalk[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = (long)chalk[i] + preSum[i - 1];
        }

        System.out.println(preSum[n - 1]);

        return findReplaceStudent(preSum, k % preSum[n - 1]);
    }

    private int findReplaceStudent(long[] arr, long tar) {
        int low = 0, high = arr.length - 1;
        System.out.println(tar);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == tar)
                return (mid + 1) % arr.length;
            else if (arr[mid] > tar)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }
}