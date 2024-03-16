class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]) {
                res = Math.min(res, nums[low]);
                break;
            }
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
                res = Math.min(res, nums[low]);
            }
            else {
                high = mid - 1;
                res = Math.min(res, nums[mid]);
            }
        }

        return res;
    }
}