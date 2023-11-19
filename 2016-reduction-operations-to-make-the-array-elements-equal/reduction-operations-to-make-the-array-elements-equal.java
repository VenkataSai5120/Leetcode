class Solution {
    public int reductionOperations(int[] nums) {
        int res = 0, len = nums.length;
        Arrays.sort(nums);
        for (int j = len - 1; j > 0; --j)
            if (nums[j - 1] != nums[j])
                res += len - j;
        return res;
    }
}