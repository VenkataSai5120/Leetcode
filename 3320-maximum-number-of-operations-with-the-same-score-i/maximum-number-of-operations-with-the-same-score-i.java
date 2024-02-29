class Solution {
    public int maxOperations(int[] nums) {
        int count = 1;
        int sum = nums[0] + nums[1];
        int index = 2;

        while (index < nums.length - 1) {
            if (sum == nums[index] + nums[index + 1]) {
                count++;
                index += 2;
            }
            else {
                break;
            }
        }

        return count;
    }
}