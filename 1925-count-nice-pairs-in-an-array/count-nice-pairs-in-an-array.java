class Solution {
    private final int mod = 1_000_000_007;
    public int countNicePairs(int[] nums) {
        int n = nums.length, res = 0;;
        int[] newNums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            newNums[i] = nums[i] - reverse(nums[i]);
        }

        for (int ele : newNums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            res = (res + map.get(ele) - 1) % mod;
        }

        return res;
    }

    private int reverse(int num) {
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        return rev;
    }
}