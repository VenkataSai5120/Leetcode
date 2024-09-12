/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[] dir = {0, 1, 0, -1, 0};
        int d = 0, i = 0, j = 0;
        int[][] res = new int[m][n];

        for (int[] arr : res) Arrays.fill(arr, -1);

        while (head != null) {
            res[i][j] = head.val;
            head = head.next;
            int a = dir[d] + i, b = j + dir[d + 1];

            if (Math.min(a, b) < 0 || a >= m || b >= n || res[a][b] != -1) d = (d + 1) % 4;

            i += dir[d]; j += dir[d + 1];
        }

        return res;
    }
}