class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Long,Long> map = new HashMap<>();
        int n = nums.length;
        map.put(0L, 1L);
        long sum = 0l;
        int ans = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            // if(sum == goal){
            //     ans++;
            // }
            if(map.get(sum-goal) != null){
                ans += map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0l)+1);
        }
        return ans;
    }
}