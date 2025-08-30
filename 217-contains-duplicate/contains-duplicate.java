class Solution {
    public boolean containsDuplicate(int[] nums) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else{
                int num = map.get(nums[i]) + 1;
                if (num >= 2) return true;
                map.put(nums[i], num);
            }
        }
        
        return false;
    }
}