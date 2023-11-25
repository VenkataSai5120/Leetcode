class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            suffixSum[n - i - 1] = suffixSum[n - i] + nums[n - i - 1];
        }

        for (int i = 0; i < n; ++i) {
            result[i] = (nums[i] * i - prefixSum[i]) + 
            (suffixSum[i] - nums[i] * (n - i - 1));
        }

        return result;
    }
}
