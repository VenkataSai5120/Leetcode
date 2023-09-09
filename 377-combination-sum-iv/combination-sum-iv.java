class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        findCSIV(nums, target, map, nums.length);
        return map.get(target);
    }
    
    public int findCSIV(int[] nums, int target, Map<Integer, Integer> map, int n) {
        if (map.containsKey(target)) return map.get(target);
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] <= target) count += findCSIV(nums, target - nums[i], map, n);
        }
        
        map.put(target, count);
        // return map.get(target);
        return count;
    }
}