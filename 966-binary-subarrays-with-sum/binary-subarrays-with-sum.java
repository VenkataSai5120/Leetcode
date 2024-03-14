class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findAtMostSum(nums, goal) - findAtMostSum(nums, goal - 1);
    }

    private int findAtMostSum(int[] nums, int goal) {
        int sum = 0;
        int res = 0;
        int head = 0, tail = 0;

        while (head < nums.length) {
            sum += nums[head];
            
            while (sum > goal && tail <= head) {
                sum -= nums[tail];
                tail++;
            }

            res += head - tail + 1;
            head++;
        }

        return res;
    }
}
