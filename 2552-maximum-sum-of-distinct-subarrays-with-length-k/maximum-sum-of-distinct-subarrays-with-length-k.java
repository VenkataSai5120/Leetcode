class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> eleCount = new HashMap<>();
        int index = 0;
        long sum = 0, res = 0;

        while (index < k) {
            eleCount.put(nums[index], eleCount.getOrDefault(nums[index], 0) + 1);
            sum += nums[index];
            index++;
        }

        if (eleCount.size() == k) res = sum;

        while (index < nums.length) {
            eleCount.put(nums[index], eleCount.getOrDefault(nums[index], 0) + 1);
            eleCount.put(nums[index - k], eleCount.get(nums[index - k]) - 1);

            sum += nums[index];
            sum -= nums[index - k];

            if (eleCount.get(nums[index - k]) == 0) eleCount.remove(nums[index - k]);
            if (eleCount.size() == k) res = Math.max(sum, res);
            index++;
        }

        return res;
    }
}
