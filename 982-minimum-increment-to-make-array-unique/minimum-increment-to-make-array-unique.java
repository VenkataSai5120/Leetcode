class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minMoves = 0;
        int currNum = 0;

        for (int ele : nums) {
            currNum = Math.max(currNum, ele);
            minMoves += currNum - ele;
            currNum += 1;
        }

        return minMoves;
    }
}