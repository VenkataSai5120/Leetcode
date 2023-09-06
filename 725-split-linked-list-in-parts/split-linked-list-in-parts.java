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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr = root;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        int partLen = size / k, extra = size % k;

        ListNode[] ans = new ListNode[k];
        curr = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = curr;
            for (int j = 0; j < partLen + (i < extra ? 1 : 0) - 1; ++j) {
                if (curr != null) curr = curr.next;
            }
            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}