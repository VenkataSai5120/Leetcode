class Solution {
        public int maxOperations(int[] nums) {
        int max = 0, n = nums.length;
        for (int score : new HashSet<>
        (List.of(nums[0] + nums[1], nums[0] + nums[n - 1], nums[n - 2] + nums[n - 1]))) {
            max = Math.max(max, findMaxOperations(nums, 0, n - 1, score, new HashMap<String, Integer>()));
        }
        return max;
    }

    private int findMaxOperations(int[] nums, int i, int j, int score,
     Map<String, Integer> dp) {
        if (j <= i) {
            return 0;
        }
        String key = i + ", " + j;
        if (!dp.containsKey(key)) {
            int max = 0;
            if (score == nums[i] + nums[i + 1]) {
                max = Math.max(max, 1 + findMaxOperations(nums, i + 2, j, score, dp));
            }
            if (score == nums[i] + nums[j]) {
                max = Math.max(max, 1 + findMaxOperations(nums, i + 1, j - 1, score, dp));
            }
            if (score == nums[j - 1] + nums[j]) {
                max = Math.max(max, 1 + findMaxOperations(nums, i, j - 2, score, dp));
            }
            dp.put(key, max);
        }
        return dp.get(key);
    }
}