class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
		int[][] dp = new int[n][n + 1];
		for (int[] a : dp) Arrays.fill(a, -1);
		return findLongest(arr, 0, -1, dp);
    }

    private static int findLongest(int[] arr, int ind, int prevInd, int[][] dp) {
		if (ind == arr.length) return 0;
		if (dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];
		int notTake = findLongest(arr, ind + 1, prevInd, dp);
        int take = 0;
		if (prevInd == -1 || arr[ind] > arr[prevInd]) {
			take = 1 + findLongest(arr, ind + 1, ind, dp);
		}
		return dp[ind][prevInd + 1] = Math.max(take, notTake);
	}
}