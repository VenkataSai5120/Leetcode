class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        int sum = 0, res = 0;
        int[] track = new int[arr.length + 1];
        track[0] = 1;
        for (int i : arr) {
            sum += i;
            if (sum >= goal) {
                res += track[sum - goal];
            }
            track[sum]++;
        }
        return res;
    }
}