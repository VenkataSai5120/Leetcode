class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            
            if (nums[mid] == target) return true;
            else if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // else if (nums[mid] == nums[low]) {
            //     low++;
            // }
            // else if (nums[mid] == nums[high]) {
            //     high--;
            // }
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (target <= nums[high] && target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }
}