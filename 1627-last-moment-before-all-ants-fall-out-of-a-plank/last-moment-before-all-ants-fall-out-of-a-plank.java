// class Solution {
//     public int getLastMoment(int n, int[] left, int[] right) {
//         Arrays.sort(left);
//         Arrays.sort(right);
//         int i = 0, j = right.length - 1;
//         int maxTime = 0;

//         while (i < left.length && j >= 0) {
//             double midPoint = left[i] - (left[i] + right[j]) / 2.0;
//             // System.out.println(midPoint);
//             int leftDistance = (int)(2 * midPoint) + n - left[i];
//             int rightDistance = (int)(2 * midPoint) + right[j];
//             maxTime = Math.max(maxTime, Math.max(leftDistance, rightDistance));
//             i++; j--;
//         }

//         while (i < left.length) {
//             maxTime = Math.max(maxTime, left[i]);
//             i++;
//         }

//         while (j >= 0) {
//             maxTime = Math.max(maxTime, n - right[j]);
//             j--;
//         }

//         return maxTime;
//     }
// }

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
        for (int i: left)
            maxTime = Math.max(maxTime, i);
        for (int i: right)
            maxTime = Math.max(maxTime, n - i);
        return maxTime;
    }
}