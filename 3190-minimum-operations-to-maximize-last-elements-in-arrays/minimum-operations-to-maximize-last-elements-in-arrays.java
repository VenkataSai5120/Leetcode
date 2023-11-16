class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int dp1 = 0, dp2 = 0, n = nums1.length;
        int min = Math.min(nums1[n - 1], nums2[n - 1]); 
        int max = Math.max(nums1[n - 1], nums2[n - 1]);

        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (Math.max(a, b) > max) return -1;
            if (Math.min(a, b) > min) return -1;
            if (a > nums1[n - 1] || b > nums2[n - 1]) dp1++;
            if (a > nums2[n - 1] || b > nums1[n - 1]) dp2++;
        }
        return Math.min(dp1, dp2);
    }
}