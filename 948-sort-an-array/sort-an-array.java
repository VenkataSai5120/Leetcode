class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int k = 0;

        for (int i = min; i <= max; i++) {
            int fre = map.getOrDefault(i, 0), j = 1;

            while (j <= fre) {
                nums[k++] = i;
                j++;
            }
        }

        return nums;
    }
}