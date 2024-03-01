class Solution {
    public int minimumCost(int[] nums) {
        int sum = nums[0], min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int ele = nums[i];
            if (ele < min1) {
                min2 = min1;
                min1 = ele;
            } else if (ele < min2) {
                min2 = ele;
            }
        }
        return sum + min1 + min2;
    }
}
