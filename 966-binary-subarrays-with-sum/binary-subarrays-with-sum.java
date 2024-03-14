class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}