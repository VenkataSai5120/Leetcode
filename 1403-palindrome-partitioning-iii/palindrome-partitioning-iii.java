class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp1 = new int[n][k + 1];
        int[][] dp2 = new int[n][n];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }

        for (int[] arr : dp2) {
            Arrays.fill(arr, -1);
        }
        return findMinChanges(s.toCharArray(), 0, k - 1, dp1, dp2);
    }

    private int findMinChanges(char[] arr, int index, int k, int[][] dp1, int[][] dp2) {
        if (index == arr.length) {
            return 0;
        }

        if (k == 0) {
            return findCost(arr, index, arr.length - 1, dp2, 0);
        }

        if (dp1[index][k] != -1) {
            return dp1[index][k];
        }

        int minChanges = (int)1e3;

        for (int i = index; i < arr.length - 1; i++) {
            minChanges = Math.min(minChanges, findCost(arr, index, i, dp2, 1) + 
                findMinChanges(arr, i + 1, k - 1, dp1, dp2));
        }

        return dp1[index][k] = minChanges;
    }

    private int findCost(char[] arr, int low, int high, int[][] dp2, int k) {
        if (low >= high) {
            return 0;
        }

        // System.out.println(low + " " + high + " " + k);

        if (dp2[low][high] != -1) {
            return dp2[low][high];
        }

        return dp2[low][high] = (arr[low] != arr[high] ? 1 : 0) + findCost(arr, low + 1, high - 1, dp2, k);
    }
}
