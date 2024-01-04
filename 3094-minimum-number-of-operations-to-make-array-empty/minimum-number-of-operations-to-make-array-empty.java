class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) map.put(ele, map.getOrDefault(ele, 0) + 1);
        int res = 0;

        for (int fre : map.values()) {
            if (fre == 1) return -1;
            res += fre / 3 + (fre % 3 == 1 || fre % 3 == 2 ? 1 : 0);
        }

        return res;
    }
}