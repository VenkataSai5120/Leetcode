class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().orElse((int)1e9);
        int high = Arrays.stream(nums).max().orElse(-(int)1e9);
        int n = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int housesRobbed = 0;
            
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    housesRobbed++;
                    i++;
                }
            }

            if (housesRobbed >= k) {
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;
    }
}