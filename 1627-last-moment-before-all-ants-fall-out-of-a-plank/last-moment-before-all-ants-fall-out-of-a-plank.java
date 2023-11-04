class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        reverse(right);
        int i = 0, j = 0;
        int maxTime = 0;

        while (i < left.length && j < right.length) {
            double midPoint = left[j] - (left[i] + right[j]) / 2.0;
            // System.out.println(midPoint);
            int leftDistance = (int)(2 * midPoint) + n - left[i];
            int rightDistance = (int)(2 * midPoint) + right[j];
            maxTime = Math.max(maxTime, Math.max(leftDistance, rightDistance));
            i++; j++;
        }

        while (i < left.length) {
            maxTime = Math.max(maxTime, left[i]);
            i++;
        }

        while (j < right.length) {
            maxTime = Math.max(maxTime, n - right[j]);
            j++;
        }

        return maxTime;
    }

    private void reverse(int[] array) {
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
}