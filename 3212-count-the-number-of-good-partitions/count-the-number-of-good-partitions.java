class Solution {
    private static final int mod = 100_000_000_7;
    public int numberOfGoodPartitions(int[] nums) {
        int res = 1, n = nums.length;
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            last.put(nums[i], i);
        }

        for (int i = 0, j = 0; i < n; ++i) {
            res = i > j ? (res * 2) % mod : res;
            j = Math.max(j, last.get(nums[i]));
        }

        return res;
    }
}