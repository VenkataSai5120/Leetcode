class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(){{put(0, -1);}};
        int currSum = 0, n = nums.length;
        
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            
            currSum %= k;
            
            Integer pre = map.get(currSum);
            
            if (pre != null) {
                if (i - pre > 1) return true;
            }
            else map.put(currSum, i);
        }
        
        return false;
    }
}