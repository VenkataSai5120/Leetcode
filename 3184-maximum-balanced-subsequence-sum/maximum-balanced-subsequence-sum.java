class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n];
        TreeMap<Integer, Long> map = new TreeMap<>();
        long res = Long.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            newNums[i] = nums[i] - i;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                res = Math.max(res, nums[i]);
            }
            else {
                long sum = nums[i];

                if (map.floorKey(newNums[i]) != null) {
                    sum += map.get(map.floorKey(newNums[i]));
                }

                while (map.ceilingKey(newNums[i]) != null && 
                map.get(map.ceilingKey(newNums[i])) < sum) {
                    map.remove(map.ceilingKey(newNums[i]));
                }

                if (map.floorKey(newNums[i]) == null || 
                map.get(map.floorKey(newNums[i])) < sum) {
                    map.put(newNums[i], sum);
                }

                res = Math.max(res, sum);
            }
        }

        return res;
    }
}