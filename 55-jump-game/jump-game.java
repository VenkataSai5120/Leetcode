class Solution {
    public boolean canJump(int[] nums) {
        int gas = 0;

        for (int amount : nums) {
            if (gas < 0) return false;
            else if (amount > gas) {
                gas = amount;
            }

            gas -= 1;
        }

        return true;
    }
}