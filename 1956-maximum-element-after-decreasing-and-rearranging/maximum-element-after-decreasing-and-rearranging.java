class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int maxEle = 1;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i - 1] - arr[i]) <= 0) {
            }
            else {
                arr[i] = arr[i - 1] + 1;
            }
            maxEle = Math.max(maxEle, arr[i]);
        }

        return maxEle;
    }
}