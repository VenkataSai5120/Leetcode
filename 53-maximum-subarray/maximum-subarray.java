class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, maxD = 0;
        
        for (int i = 0; i < nums.length; i++){
            maxD += nums[i];
            maxSum = Math.max(maxSum, maxD);
            maxD = Math.max(0, maxD);
        }
        
        return maxSum;
    }
}