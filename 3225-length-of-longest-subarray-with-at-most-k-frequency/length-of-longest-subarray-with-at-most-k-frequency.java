class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int index1 = 0, index2 = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;

        while (index1 < nums.length) {

            if (freq.getOrDefault(nums[index1], 0) + 1 > k) {
                maxLen = Math.max(maxLen, index1 - index2);
                while (freq.getOrDefault(nums[index1], 0) + 1 > k) {
                    freq.put(nums[index2], freq.getOrDefault(nums[index2], 0) - 1);
                    index2++;
                }
            }

            freq.put(nums[index1], freq.getOrDefault(nums[index1], 0) + 1);
            index1++;
        }

        maxLen = Math.max(maxLen, index1 - index2);
        return maxLen;
    }
}