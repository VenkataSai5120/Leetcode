class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> collected = new HashSet<>();
        int i = nums.size() - 1;

        for (; i >= 0 && collected.size() != k; i--) {
            if (nums.get(i) <= k) collected.add(nums.get(i));
        }

        return nums.size() - i - 1;
    }
}