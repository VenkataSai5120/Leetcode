class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for (int ele : nums) {
            if (ele > max1) {
                max2 = max1;
                max1 = ele;
            }
            else if (ele > max2) {
                max2 = ele;
            }
        }
        max1--; max2--;

        return max1 * max2;
    }
}