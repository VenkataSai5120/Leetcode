class Solution {
    public int minCapability(int[] A, int k) {
        int left = 1 , right = Arrays.stream(A).max().orElse(Integer.MIN_VALUE);
        int n = A.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i)
                if (A[i] <= mid) {
                    take += 1;
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}