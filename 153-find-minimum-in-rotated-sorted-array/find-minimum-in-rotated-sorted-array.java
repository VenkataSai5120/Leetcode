class Solution {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int res = (int)1e9;

    while (l <= r) {
      int m = (l + r) / 2;
      if (nums[l] <= nums[m]) {
          res = Math.min(res, nums[l]);
          l = m + 1;
      }
      else {
          res = Math.min(res, nums[m]);
          r = m - 1;
      }
    }

    return res;
  }
}